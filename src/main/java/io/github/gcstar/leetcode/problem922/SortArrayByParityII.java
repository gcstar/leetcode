package io.github.gcstar.leetcode.problem922;

/**
 * Created by guchao on 19/1/7.
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int length = A.length;
        while (i < length && j < length) {
            while (i < length && !isOdd(A[i])) {
                i += 2;
            }
            while (j < length && isOdd(A[j])) {
                j += 2;
            }

            if (i < A.length && j < A.length) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }

    public boolean isOdd(int num) {
        return num % 2 == 1 ? true : false;
    }
}
