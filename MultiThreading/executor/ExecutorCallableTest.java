package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by rhwayfun on 16-4-4.
 */
public class ExecutorCallableTest {

    /**
     * Callable任务
     */
    static class Runner implements Callable<String> {

        private String runId;

        public Runner(String runId) {
            this.runId = runId;
        }

        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " call method is invoked!");
            return Thread.currentThread().getName() + " call method and id is " + runId;
        }
    }

    /**
     * Main program.
     * @param args Arguments for main program.
     */
    public static void main(String[] args) {
        //线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //接收Callable任务的返回结果
        List<Future<String>> futureTaskList = new ArrayList<Future<String>>();

        for (int i = 0; i < 5; i++) {
            Future<String> future = cachedThreadPool.submit(new Runner(String.valueOf(i)));
            futureTaskList.add(future);
        }

        //遍历线程执行的返回结果
        for (Future<String> f : futureTaskList) {
            try {
                //如果任务没有完成则忙等待
                while (!f.isDone()) {}
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                //关闭线程池，不再接收新的任务
                cachedThreadPool.shutdown();
            }
        }
    }
}