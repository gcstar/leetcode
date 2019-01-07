package io.github.gcstar.leetcode.problem1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guchao on 19/1/7.
 */
public class TwoSumTest {

    @Test
    public void test() {
        TwoSum sum = new TwoSum();
        int[] result = sum.twoSum(new int[]{1, 2}, 3);
        int[] result1 = sum.twoSum(new int[]{1, 2, 3, 4, 6}, 10);
        Assert.assertArrayEquals(new int[]{0, 1}, result);
        Assert.assertArrayEquals(new int[]{3,4},result1);
    }
}
