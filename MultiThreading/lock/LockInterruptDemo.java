package lock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by https://blog.csdn.net/u011116672/article/details/51064186
 */
public class LockInterruptDemo {

    //锁对象
    private static Lock lock = new ReentrantLock();

    //日期格式器
    private static DateFormat format = new SimpleDateFormat("HH:mm:ss");

    /**
     * 写数据
     */
    public void write() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":start writing data at "
                    + format.format(new Date()));
            long start = System.currentTimeMillis();
            for (;;){
                if (System.currentTimeMillis() - start > 1000 * 15){
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + ":finish writing data at "
                    + format.format(new Date()));
        }finally {
            lock.unlock();
        }
    }

    /**
     * 读数据
     */
    public void read() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(Thread.currentThread().getName() + ":start reading data at "
                    + format.format(new Date()));
        }finally {
            lock.unlock();
        }
    }

    /**
     * 执行写数据的线程
     */
    static class Writer implements Runnable {

        private LockInterruptDemo lockInterruptDemo;

        public Writer(LockInterruptDemo lockInterruptDemo) {
            this.lockInterruptDemo = lockInterruptDemo;
        }

        public void run() {
            lockInterruptDemo.write();
        }
    }

    /**
     * 执行读数据的线程
     */
    static class Reader implements Runnable {

        private LockInterruptDemo lockInterruptDemo;

        public Reader(LockInterruptDemo lockInterruptDemo) {
            this.lockInterruptDemo = lockInterruptDemo;
        }

        public void run() {
            try {
                lockInterruptDemo.read();
                System.out.println(Thread.currentThread().getName() + ":finish reading data at "
                        + format.format(new Date()));
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": interrupt reading data at "
                        + format.format(new Date()));
            }
            System.out.println(Thread.currentThread().getName() + ":end reading data at "
                    + format.format(new Date()));
        }
    }

    /**
     * Main program.
     * @param args Arguments for main program.
     * @throws InterruptedException
     * 读线程正常响应了我们的中断，因为读线程输出了中断信息，即使写线程写完数据后，读线程也没有输出结束读数据的信息，这点是在我们意料之中的。这样也验证了可中断锁的分析。
     */
    public static void main(String[] args) throws InterruptedException {

        LockInterruptDemo lockInterruptDemo = new LockInterruptDemo();

        Thread writer = new Thread(new Writer(lockInterruptDemo), "Writer");
        Thread reader = new Thread(new Reader(lockInterruptDemo), "Reader");

        writer.start();

        // 让writer比reader先运行
        TimeUnit.SECONDS.sleep(1);

        reader.start();

        //运行5秒，然后尝试中断
        TimeUnit.SECONDS.sleep(5);
        System.out.println(reader.getName() + ":I don't want to wait anymore at " + format.format(new Date()));

        //中断读的线程
        reader.interrupt();
    }

}