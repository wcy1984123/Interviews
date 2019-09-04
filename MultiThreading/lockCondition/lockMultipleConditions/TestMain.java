package lockCondition.lockMultipleConditions;

/**
 * Test main class.
 */
public class TestMain {

    /**
     * Main program
     * 
     * @param args Arguments for main program.
     */
    public static void main(String args[]) {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>();
        final int numberOfWorkers = 10;

        for (int i = 0; i < numberOfWorkers; i++) {
            new Thread(new Consumer(buffer)).start();
        }

        for (int i = 0; i < numberOfWorkers; i++) {
            new Thread(new Producer(buffer)).start();
        }
    }
}