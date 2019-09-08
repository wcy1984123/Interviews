package atomics;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rhwayfun on 16-4-5.
 */
public class AtomicIntegerDemo {

    /**
     * AtomicInteger instance.
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * Main program.
     * 
     * @param args Arguments for main program.
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    // 调用AtomicInteger的getAndIncement返回的是增加之前的值
                    System.out.println(atomicInteger.getAndIncrement());
                }
            }).start();
        }

        System.out.println(atomicInteger.get());
    }
}