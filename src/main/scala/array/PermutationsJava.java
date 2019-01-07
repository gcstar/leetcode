package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by guchao on 19/1/4.
 * leetcode 46
 */
public class PermutationsJava {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        permuteRec(list, 0, result);

        return result;
    }

    static void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
        } else {
            for (int i = start; i < nums.size(); i++) {
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                Collections.swap(nums, i, start);

            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            for (int num : list) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }
}
