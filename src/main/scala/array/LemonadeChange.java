package array;

import java.util.Deque;

/**
 * Created by guchao on 18/12/21.
 * leetcode 860
 */
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int[] changes = new int[]{0, 0};
        for (int i : bills) {
            if (i == 5) {
                changes[0] = changes[0] + 1;
                continue;
            } else if (i == 10) {
                if (changes[0] == 0) {
                    return false;
                } else {
                    changes[0] -= 1;
                    changes[1] += 1;
                }
                ;
            } else if (i == 20) {
                if ((changes[1] >= 1 && changes[0] >= 1)) {
                    changes[1] -= 1;
                    changes[0] -= 1;
                } else if (changes[0] >= 3) {
                    changes[0] -= 3;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        boolean f = lemonadeChange(new int[]{5,5,5,10,20});
        System.out.println(f);
    }
}
