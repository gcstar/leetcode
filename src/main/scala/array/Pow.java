package array;

/**
 * Created by guchao on 19/1/4.
 * leetcode 50
 */
public class Pow {

    public static double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double res = 1.0;
        long len = Math.abs((long)n);
        while (len > 0) {
            res *= x;
            len--;
        }
        return n < 0 ? 1 / res : res;
    }

    public static double pastMyPow(double x, int n) {
        double result = 1;
        long N = Math.abs((long) n);

        while (N != 0) {
            if ((N & 1) == 1) result *= x;
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1 / result : result;
    }

    public static void main(String[] args) {

        System.out.println(pastMyPow(2.1, -4));

    }
}
