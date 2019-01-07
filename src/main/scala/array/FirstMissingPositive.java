package array;

import java.util.TreeMap;

/**
 * Created by guchao on 18/12/24.
 * leetcode 41
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int key = 0;
        TreeMap<Integer, Boolean> map = new TreeMap();
        for (int i = 1; i <= nums.length + 1; i++) {
            map.put(i, false);
        }

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, true);
            }
        }


        for (int k : map.keySet()) {
            if (map.get(k) == false) {
                key = k;
                break;
            }
        }
        return key;

    }

    public static void main(String[] args) {

        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{2, 1}));


    }
}
