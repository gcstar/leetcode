package array;

/**
 * Created by guchao on 18/12/24.
 * leetcode 5
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        } else if (s.length() == 2 && s.charAt(0) != s.charAt(1)) {
            return s.substring(0, 1);
        }
        int begin = 0;
        int end = s.length() - 1;
        for (int i = begin, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                begin++;
                end--;
            }
        }
        return s.substring(begin, end + 1);

    }


    public static void main(String[] args) {

        System.out.println(longestPalindrome("abb"));

    }
}
