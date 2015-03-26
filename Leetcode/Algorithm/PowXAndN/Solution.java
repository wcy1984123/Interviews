package PowXAndN;

/**
 * Project: Interviews
 * Package: PowXAndN
 * Date: 21/Mar/2015
 * Time: 14:45
 * System Time: 2:45 PM
 */

/*
    Implement pow(x, n).
 */

public class Solution {
    public double power(double x, int n) {
        if (n == 0)
            return 1;

        double v = power(x, n / 2);

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public double pow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }
}
