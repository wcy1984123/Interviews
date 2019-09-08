package lockCondition.lockMultipleConditions;

public class Consumer implements Runnable {
    private final BoundedBuffer<Integer> buffer;

    public Consumer(BoundedBuffer<Integer> buffer) {
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
            Integer result = this.buffer.take();

            System.out.println(
                    "Thread [" + Thread.currentThread().getId() + "] take [" + result + "] out from the list.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}