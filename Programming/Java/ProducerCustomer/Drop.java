package ProducerCustomer;

/**
 * Project: Interviews
 * Package: ProducerCustomer
 * Date: 25/Oct/2015
 * Time: 11:38
 * System Time: 11:38 AM
 */

public class Drop {

    // Message sent from producer to consumer. That is what producer creates.
    private String message;

    // True if consumer should wait for producer to send message, false if producer should wait for consumer to retrieve message.
    private boolean empty = true;

    /**
     * Customer
     * @return products made by producer
     */
    public synchronized String take() {

        // Wait until message is available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        // Toggle status.
        empty = true;

        // Notify producer that status has changed.
        notifyAll();

        return message;
    }

    /**
     * producer
     */
    public synchronized void put(String message) {
        // Wait until message has been retrieved.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        // Toggle status.
        empty = false;

        // Store message.
        this.message = message;

        // Notify consumer that status has changed.
        notifyAll();
    }
}
