package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by guchao on 18/12/21.
 * leetcode 637
 */
public class DegreeOfAnArray {
    public static int findShortestSubArray(int[] nums) {

        if (nums.length == 1) return 1;

        Map<Integer, int[]> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] indexs = map.get(nums[i]);
            if (indexs == null) {
                int count = 1;
                map.put(nums[i], new int[]{i, i, 1});
                max = Math.max(max,count);
            } else {
                int begin = indexs[0];
                int count = indexs[2] + 1;
                if (count > max) {
                    max = count;
                }
                map.put(nums[i], new int[]{begin, i, count});
            }
        }
        int min = Integer.MAX_VALUE;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            int[] value = map.get(key);
            if (value[2] == max) {
                int length = value[1] - value[0] + 1;
                if (length < min) {
                    min = length;
                }
            }

        }
        return min;

    }

    public static void main(String[] args) {
        int i = findShortestSubArray(new int[]{1,1, 2});
        System.out.println(i);
    }
}
