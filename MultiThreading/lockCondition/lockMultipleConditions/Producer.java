package lockCondition.lockMultipleConditions;

import java.util.Random;

/**
 * Producer class.
 */
public class Producer implements Runnable {
    /**
     * Buffer to put item by producer.
     */
    private final BoundedBuffer<Integer> buffer;

    /**
     * Class constructor.
     * 
     * @param buffer Buffer to put item.
     */
    public Producer(BoundedBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used to create
     * a thread, starting the thread causes the object's <code>run</code> method to
     * be called in that separately executing thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may take any
     * action whatsoever.
     *
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        try {
            Random rd = new Random();
            int value = rd.nextInt(100);

            this.buffer.put(value);
            System.out.println("Thread [" + Thread.currentThread().getId() + "] put [" + value + "] in the list.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}