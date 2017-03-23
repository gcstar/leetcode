package gc.temp;

import org.junit.Test;

/**
 * 判断一个整数是否为回文数
 * e.g 121 1221
 * Created by guchao on 2017/3/23.
 *
 * @author guchao
 * @date 2017/03/23
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        boolean result = true;
        String str = String.valueOf(x);

        int length = str.length();

        for (int i = 0, j = length - 1; i <= j; i++, j--) {
            char begin = str.charAt(i);
            char end = str.charAt(j);
            result = begin != end ? false : true;
            if (!result) {
                return result;
            }
        }
        return result;
    }

    @Test
    public void PalindromeNumberTest() {
        System.out.println(isPalindrome(12321));
    }
}
