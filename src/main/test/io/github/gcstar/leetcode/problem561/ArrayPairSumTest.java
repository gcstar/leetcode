package io.github.gcstar.leetcode.problem561;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by guchao on 19/1/7.
 */
public class ArrayPairSumTest {
    @Test
    public void arrayPairSum() throws Exception {
        ArrayPairSum test = new ArrayPairSum();
        int i = test.arrayPairSum(new int[]{1, 4, 3, 2});
        Assert.assertEquals(4,i);
    }

}