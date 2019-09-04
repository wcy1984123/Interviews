package lockCondition.lockSignleCondition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ttps://blog.csdn.net/u011116672/article/details/51064752
 * 相比Object实现的监视器方法，Condition接口的监视器方法具有一些Object所没有的特性：

    Condition接口可以支持多个等待队列，在前面已经提到一个Lock实例可以绑定多个Condition，所以自然可以支持多个等待队列了
    Condition接口支持响应中断，前面已经提到过
    Condition接口支持当前线程释放锁并进入等待状态到将来的某个时间，也就是支持定时功能
    --------------------- 
    作者：rhwayfunn 
    来源：CSDN 
    原文：https://blog.csdn.net/u011116672/article/details/51064752 
    版权声明：本文为博主原创文章，转载请附上博文链接
 */
public class ConditionProducerConsumerDemo {

    //日期格式器
    private static DateFormat format = new SimpleDateFormat("HH:mm:ss");

    static class Info{
        //作者
        private String author;
        //标题
        private String title;
        //是否开始生产的标志
        private boolean produce = true;
        //Lock锁
        private Lock lock = new ReentrantLock();
        //Condition变量
        private Condition condition = lock.newCondition();

        public Info(){}

        public Info(String author, String title) {
            this.author = author;
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * 生产者执行的生产方法
         * @param author
         * @param title
         * @throws InterruptedException
         */
        public void set(String author,String title) throws InterruptedException {
            lock.lock();
            try {
                //没有开始生产就等待
                while (!produce){
                    condition.await();
                }
                //如果已经开始生产
                this.setAuthor(author);
                TimeUnit.SECONDS.sleep(1);
                this.setTitle(title);
                //表示已经停止了生产可以取数据了
                produce = false;
                //通知消费者
                condition.signal();
            }finally {
                lock.unlock();
            }
        }

        /**
         * 消费者执行的消费方法
         * @throws InterruptedException
         */
        public void get() throws InterruptedException {
            lock.lockInterruptibly();
            try {
                //如果已经开始生产就等待
                while (produce){
                    condition.await();
                }
                //如果没有在生产就就可以取数据
                System.out.println(Thread.currentThread().getName() + ":" + this.getAuthor()
                        + "=" + this.getTitle() + " at "
                        + format.format(new Date()));
                //表示我已经取了数据，生产者可以继续生产
                produce = true;
                //通知生产者
                condition.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    /**
     * Producer class.
     */
    static class Producer implements Runnable{

        private Info info;

        public Producer(Info info) {
            this.info = info;
        }

        public void run() {
            boolean flag = true;
            for (int i = 0; i < 5; i++){
                if (flag){
                    try {
                        info.set("authorA","titleA");
                        System.out.println(Thread.currentThread().getName() + ":" + info.getAuthor() + "="
                                + info.getTitle() + " at " + format.format(new Date()));
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = false;
                }else {
                    try {
                        info.set("authorB","titleB");
                        System.out.println(Thread.currentThread().getName() + ":" + info.getAuthor() + "="
                                + info.getTitle() + " at " + format.format(new Date()));
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = true;
                }
            }
        }
    }

    /**
     * Consumer class.
     */
    static class Consumer implements Runnable{

        private Info info;

        public Consumer(Info info) {
            this.info = info;
        }

        public void run() {
            for (int i = 0; i < 5; i++){
                try {
                    info.get();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * Main program.
     * @param args Arguments for main program.
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Info info = new Info();

        Thread producer = new Thread(new Producer(info),"Producer");
        Thread consumer = new Thread(new Consumer(info),"Consumer");

        producer.start();
        TimeUnit.SECONDS.sleep(1);
        consumer.start();
    }
}