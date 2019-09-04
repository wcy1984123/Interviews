package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by rhwayfun on 16-4-6.
 * 作者：rhwayfunn 
    来源：CSDN 
    原文：https://blog.csdn.net/u011116672/article/details/51075990 
    版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class SemaphoreDemo {

    /**
     * 并发执行的线程数
     */
    private static final int THREAD_COUNT = 10;

    /**
     * 线程池
     */
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    /**
     * 信号量
     * 只有2个许可证
     */
    private static Semaphore semaphore = new Semaphore(2);

    /**
     * Main program.
     * @param args Arguments for main program.
     */
    public static void main(String[] args){
        for (int i = 0; i < THREAD_COUNT; i++){
            final int num = i;
            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        //获取许可证
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " acquire permit " + num);

                        //输出信息
                        for (int i = 0; i < 999999;i++);
                        System.out.println("save data!");

                        //释放许可证
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName() + " release permit " + num);
                        
                        //当前可用的许可证
                        System.out.println("     current available permits:" + semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}