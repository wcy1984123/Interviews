package ProducerCustomer;

/**
 * Project: Interviews
 * Package: ProducerCustomer
 * Date: 25/Oct/2015
 * Time: 11:37
 * System Time: 11:37 AM
 */
public class Solution {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
