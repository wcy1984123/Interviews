package threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by rhwayfun on 16-4-8.
 * 作者：rhwayfunn 
    来源：CSDN 
    原文：https://blog.csdn.net/u011116672/article/details/51100337 
    版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class PersonThreadLocalDemo {

    private static final ThreadLocal<Person> personLocal = new ThreadLocal<>();
    private static final Random ran = new Random();
    private static final DateFormat format = new SimpleDateFormat("HH:mm:ss");

    /**
     * 不同的线程并发修改Person的age属性
     */
    static class Worker implements Runnable{
        @Override
        public void run() {
            doExec();
        }

        private void doExec() {
            System.out.println(Thread.currentThread().getName() + " start task at "
                    + format.format(new Date()));

            //不同的线程会会将age属性设置成不同的值
            int age = ran.nextInt(20);
            Person p = getPerson();
            
            //设置年龄
            p.setAge(age);
            System.out.println(Thread.currentThread().getName() + ": set age to " + p.getAge() + " at "
                + format.format(new Date()));


            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": get age " + p.getAge() + " at "
                + format.format(new Date()));
        }

        /**
         * Get person form ThreadLocal.
         * @return
         */
        protected Person getPerson() {
            Person p = personLocal.get();
            if (p == null){
                p = new Person();
                personLocal.set(p);
            }
            return p;
        }
    }

    /**
     * Main program.
     * @param args Arguments for main program.
     */
    public static void main(String[] args){
        Worker worker = new Worker();
        new Thread(worker,"worker-1").start();
        new Thread(worker,"worker-2").start();
    }
}