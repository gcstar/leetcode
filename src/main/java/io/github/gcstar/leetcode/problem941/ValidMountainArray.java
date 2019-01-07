package io.github.gcstar.leetcode.problem941;

import java.util.Arrays;

/**
 * Created by guchao on 19/1/7.
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        int[] max = new int[]{0,A[0]};
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max[1]) {
                max[0] = i;
                max[1] = A[i];
            }
        }
        if (max[0] == 0 || max[0] == A.length - 1) return false;
        int[] before = Arrays.copyOfRange(A, 0, max[0] + 1);
        int[] after = Arrays.copyOfRange(A, max[0], A.length);
        int temp = before[0];
        for (int i = 1; i < before.length; i++) {
            if (before[i] <= temp) return false;
            temp = before[i];
        }
        temp = after[0];
        for (int i = 1; i < after.length; i++) {
            if (after[i]>= temp) return false;
            temp = after[i];
        }
        return true;
    }
}
