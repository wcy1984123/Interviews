package threadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 测试程序
 */
public class DemoThreadPoolTest {
    /**
     * Main program.
     * 
     * @param args Arguments for main program.
     * @throws InterruptedException thrown if it is interrupted.
     */
    public static void main(String[] args) throws InterruptedException {
        // 日期格式器
        final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        // 创建线程池
        DemoThreadPool<DemoThread> threadPool = new DemoThreadPool<>();
        
        // 添加15个任务
        for (int i = 0; i < 15; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " get result " + format.format(new Date()));
                }
            };

            threadPool.execute(task);
        }

        threadPool.shutdown();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("work done! Time is " + format.format(new Date()));
    }
}