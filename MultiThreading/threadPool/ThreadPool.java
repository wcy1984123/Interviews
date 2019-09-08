package threadPool;

/**
 * 线程池接口
 *
 */
public interface ThreadPool<Job extends Runnable> {
    // 执行任务
    void execute(Job job);

    // 关闭线程池
    void shutdown();
}