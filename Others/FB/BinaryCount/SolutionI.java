package BinaryCount;

/**
 * Project: Interviews
 * Package: BinaryCount
 * Date: 23/Mar/2015
 * Time: 12:35
 * System Time: 12:35 PM
 */
public class SolutionI {
    int binaryCount(int num) {
        int count = 0;
        while(num > 0) {
            ++count;
            num&= num - 1; // should be &, not ^
        }
        return count;
    }
}
