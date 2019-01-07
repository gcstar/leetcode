package array;

import scala.Int;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guchao on 18/12/21.
 * leetcode 728
 */
public class SelfDividingNumbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (String.valueOf(i).contains("0")) continue;
            if (isSelfDividingNumbers(i)) {
                result.add(i);
            }
        }
        return result;

    }

    public static boolean isSelfDividingNumbers(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (char c : chars) {
            if (num % Integer.valueOf(String.valueOf(c)) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        List<Integer> list = selfDividingNumbers(1, 22);
        for (int i : list) {
            System.out.print(i + ",");
        }
    }
}
