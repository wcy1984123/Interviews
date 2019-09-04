package reentrantReadWriteLock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 组合使用一个非线程安全的HashMap作为缓存的实现，同时使用读锁和写锁来保证Cache是线程安全的。在读操作get方法中使用读锁，使得并发访问该方法的时候不会阻塞
 * 在写操作put方法中使用写锁，在更新HashMap的时候必须提前获取写锁，获取写锁的线程将会阻塞读锁和写锁的获取，而只有在写锁被释放后其他读写操作才能继续执行。
 * --------------------- 作者：rhwayfunn 来源：CSDN
 * 原文：https://blog.csdn.net/u011116672/article/details/51065711
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class Cache {

    /**
     * Non-Threading safe hashmap.
     */
    static Map<String, Object> map = new HashMap<String, Object>();

    /**
     * RenetrantReadWriteLock lock.
     */
    static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    /**
     * Read lock.
     */
    static Lock readLock = rw.readLock();

    /**
     * Write lock.
     */
    static Lock writeLock = rw.writeLock();

    /**
     * Date format.
     */
    static DateFormat format = new SimpleDateFormat("HH:mm:ss");

    /**
     * 获取一个key对应的value
     * 
     * @param key
     * @return
     */
    public static final Object get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 设置key对应的value，并返回旧的value
     * 
     * @param key
     * @param value
     */
    public static final Object put(String key, Object value) {
        writeLock.lock();
        try {
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 清空所有的内容
     */
    public static final void clear() {
        writeLock.lock();
        try {
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 写线程
     */
    static class Writer implements Runnable {
        private Cache cache;

        public Writer(Cache cache) {
            this.cache = cache;
        }

        public void run() {
            long start = System.currentTimeMillis();
            int i = 0;
            for (;; i++) {
                if (System.currentTimeMillis() - start > 1000 * 5) {
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String value = format.format(new Date());

                // Update cache.
                cache.put(String.valueOf(i), value);

                System.out.println(Thread.currentThread().getName() + ":is writing data " + String.valueOf(i) + "="
                        + value + " at " + format.format(new Date()));
            }
            System.out
                    .println(Thread.currentThread().getName() + ":finish writing data at " + format.format(new Date()));
        }
    }

    /**
     * 读线程
     */
    static class Reader implements Runnable {

        private Cache cache;

        public Reader(Cache cache) {
            this.cache = cache;
        }

        public void run() {
            int i = 0;
            for (;; i++) {
                Object obj = cache.get(String.valueOf(i));
                if (obj instanceof String) {
                    System.out.println(Thread.currentThread().getName() + ":is reading data " + String.valueOf(i) + "="
                            + obj + " at " + format.format(new Date()));
                }
            }
        }
    }

    /**
     * Main program.
     * 
     * @param args Arguments for main program.
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();

        // 一个thread先write数据
        new Thread(new Writer(cache), "Writer").start();
        TimeUnit.SECONDS.sleep(5);

        // 多个thread同时read数据
        for (int i = 0; i < 5; i++) {
            new Thread(new Reader(cache), "Reader" + i).start();
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("Main program end.");
    }
}