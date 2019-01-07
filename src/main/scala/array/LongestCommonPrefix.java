package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by guchao on 18/12/24.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length ==0) return "";
        int length = Integer.MAX_VALUE;
        int maxLength = 0;
        for (String s : strs) {
            length = Math.min(s.length(), length);
        }
        if (length == 0) return "";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (String s : strs) {
                set.add(s.charAt(i));
            }
            if (set.size() == 1) {
                maxLength += 1;
                set.clear();
            }
        }
        return strs[0].substring(0,maxLength);
    }

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"aflower","flow","flight"}));

    }
}
