package io.github.gcstar.leetcode.problem922;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by guchao on 19/1/7.
 */
public class SortArrayByParityIITest {
    @Test
    public void sortArrayByParityII() throws Exception {
        SortArrayByParityII test = new SortArrayByParityII();
        int[] res = test.sortArrayByParityII(new int[]{4, 2, 5, 7});
        Assert.assertArrayEquals(new int[]{4, 5, 2, 7}, res);
    }

}