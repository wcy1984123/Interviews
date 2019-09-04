package lockCondition.lockMultipleConditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;

/*
    Multiple conditions usage example.
*/
public class BoundedBuffer<V> {
    final Lock lock = new ReentrantLock();// 锁对象
    final Condition notFull = lock.newCondition();// 写线程条件变量
    final Condition notEmpty = lock.newCondition();// 读线程条件变量

    final LinkedList<V> items = new LinkedList<V>();
    final int totalCount = 5;

    public void put(V x) throws InterruptedException {
        lock.lock();
        try {
            while (items.size() >= totalCount) {
                // 如果队列满了
                System.out
                        .println("Thread [" + Thread.currentThread().getId() + "] The queue has been FULL. Waiting...");
                notFull.await();// 阻塞写线程
            }

            items.addLast(x);
            notEmpty.signal();// 唤醒读线程
        } finally {
            lock.unlock();
        }
    }

    public V take() throws InterruptedException {
        lock.lock();
        try {
            while (items.size() == 0) {
                // 如果队列为空
                System.out.println(
                        "Thread [" + Thread.currentThread().getId() + "] The queue has been EMPTY. Waiting...");
                notEmpty.await();// 阻塞读线程
            }

            V x = items.removeFirst();
            notFull.signal();// 唤醒写线程
            return x;
        } finally {
            lock.unlock();
        }
    }
}