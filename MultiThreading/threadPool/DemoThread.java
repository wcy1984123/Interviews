package threadPool;

import java.util.concurrent.BlockingQueue;

/**
 * 工作者线程
 */
public class DemoThread implements Runnable {
    // work queue
    private BlockingQueue<Runnable> workQueue;

    // indicator to be shut down.
    private volatile boolean shutdown = false;

    public DemoThread(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public void run() {
        while (!shutdown) {
            try {
                Runnable job = workQueue.take();
                job.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopToSelf() {
        shutdown = true;

        // 调用interrupt方法让等待在工作队列打算出队的线程从wait方法返回
        new Thread(this).interrupt();
    }
}