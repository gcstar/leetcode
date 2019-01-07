package dp;

/**
 * Created by guchao on 19/1/4.
 */
public class NonnegativeIntegerswithoutConsecutiveOnes {
    public int findIntegers(int num) {
        if (num == 0) return 1;
        String s = Integer.toBinaryString(num);
        int len = s.length();

        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int sum = 0;
        for (int i = 0, k = len; i < len; i++, k--) {
            if (s.charAt(i) == '1') {
                sum += dp[k - 1];
                if (i > 0 && s.charAt(i - 1) == '1') {
                    return sum;
                }
            }
        }
        sum++;
        return sum;
    }
}
