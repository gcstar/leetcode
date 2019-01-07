package io.github.gcstar.leetcode.problem561;

import java.util.Arrays;

/**
 * Created by guchao on 19/1/7.
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) res += nums[i];
        }
        return res;

    }
}
