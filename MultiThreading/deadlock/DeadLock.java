package deadlock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Dead lock program for demonstrating how two threads lock each other.
 */
public class DeadLock {

    private static DateFormat format = new SimpleDateFormat("HH:mm:ss");

    /**
     * Try to call other function.
     * @param other Other function.
     * @throws InterruptedException Interrupted exception.
     */
    public synchronized void tryOther(DeadLock other) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " enter tryOther method at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName() + " tryOther method is about to invoke other method at " + format.format(new Date()));
        other.other();
    }

    /**
     * Other function.
     * @throws InterruptedException Interrupted exception.
     */
    public synchronized void other() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " enter other method at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     * Main program.
     * @param args Arguments for the main program.
     * @throws InterruptedException Interrupted exception.
     */
    public static void main(String[] args) throws InterruptedException {
        final DeadLock d1 = new DeadLock();
        final DeadLock d2 = new DeadLock();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    d1.tryOther(d2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadA");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    d2.tryOther(d1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadB");

        t1.start();
        //让threadA先运行一秒
        TimeUnit.SECONDS.sleep(1);
        t2.start();

        //运行10秒后尝试中断线程
        TimeUnit.SECONDS.sleep(10);
        t1.interrupt();
        t2.interrupt();

        System.out.println("Is threadA is interrupted? " + t1.isInterrupted());
        System.out.println("Is threadB is interrupted? " + t2.isInterrupted());
    }
}