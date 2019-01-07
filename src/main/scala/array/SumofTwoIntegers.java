package array;

/**
 * Created by guchao on 18/12/21.
 * leetcode 371
 */
public class SumofTwoIntegers {
    public static int getSum(int a, int b) {
        while (b != 0) {
            int t = a ^ b;
            b = (a & b) << 1;
            a = t;
        }
        return a;

    }
    public static void main(String[] args) {
        System.out.println(getSum(30, 20));
    }
}
