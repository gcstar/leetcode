package array;

import java.util.Stack;

/**
 * Created by guchao on 18/12/21.
 * leetcode 657
 */
public class RobotReturntoOrigin {
    public static boolean judgeCircle(String moves) {
        char[] steps = moves.toCharArray();
        int[] s = new int[]{0, 0};
        for (char step : steps) {
            switch (step) {
                case 'U':
                    s[0] = s[0] + 1;
                    break;
                case 'D':
                    s[0] = s[0] - 1;
                    break;
                case 'L':
                    s[1] = s[1] - 1;
                    break;
                case 'R':
                    s[1] = s[1] + 1;
                    break;
            }
        }

        return s[0] == 0 && s[1] == 0;

    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UDLR"));

    }
}
