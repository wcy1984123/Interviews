package cyclicBarrier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by rhwayfun on 16-4-6.
 * 作者：rhwayfunn 
    来源：CSDN 
    原文：https://blog.csdn.net/u011116672/article/details/51074815 
    版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class CyclicBarrierDemo {

    //参数3表示的是屏障拦截的线程数
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    //日期格式器
    static final DateFormat format = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        //第一个读取的线程
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                for (;;){
                    if (System.currentTimeMillis() - start > 1000 * 10){
                        break;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " finished task at " + format.format(new Date()));
                try {
                    //调用await方法告诉CyclicBarrier我已经到达了屏障
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-1");

        //第二个线程开始读取
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                for (;;){
                    if (System.currentTimeMillis() - start > 1000 * 5){
                        break;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " finished task at " + format.format(new Date()));
                try {
                    //表示当前线程已经到达了屏障
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        System.out.println(Thread.currentThread().getName() + " start task at " + format.format(new Date()));

        thread1.start();
        thread2.start();

        //主线程调用await方法表示主线程已经到达了屏障
        cyclicBarrier.await();
        System.out.println(Thread.currentThread().getName() + " ended task at " + format.format(new Date()));
    }
}