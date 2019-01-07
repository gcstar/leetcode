package io.github.gcstar.leetcode.problem941;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guchao on 19/1/7.
 */
public class ValidMountainArrayTest {
    @Test
    public void test() {

        ValidMountainArray test = new ValidMountainArray();
        boolean res = test.validMountainArray(new int[]{1, 2, 3});
        boolean res1 = test.validMountainArray(new int[]{1, 2, 3, 3, 4, 5});
        boolean res2 = test.validMountainArray(new int[]{1, 2, 3, 4, 5, 3});
        boolean res3 = test.validMountainArray(new int[]{3, 5, 5});


        Assert.assertEquals(false, res);
        Assert.assertEquals(false, res1);
        Assert.assertEquals(true, res2);
        Assert.assertEquals(false, res3);


    }
}
