package dp;

/**
 * Created by guchao on 19/1/4.
 */
public class CountingBits {
    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int n = i;
            int size = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    size++;
                }
                n >>= 1;
            }
            res[i] = size;
        }
        return res;
    }

    public static int[] countBitsDP(int num) {
        if (num == 0) return new int[]{0};
        int[] DP = new int[num + 1];
        DP[0] = 0;
        DP[1] = 1;
        int t = 1;
        for (int i = 2; i <= num; i++) {
            if (i == (t << 1)) {
                DP[i] = 1;
                t <<= 1;
            } else {
                DP[i] = DP[i - t] + 1;
            }
        }
        return DP;
    }

    public static void main(String[] args) {
        System.out.println(countBitsDP(3));
        int[] r = countBitsDP(5);
        for (int n : r) {
            System.out.print(n + ",");
        }
    }


}
