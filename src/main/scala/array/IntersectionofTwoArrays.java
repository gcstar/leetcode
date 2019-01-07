package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by guchao on 18/12/21.
 */
public class IntersectionofTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> r = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }

        for(int n:nums2){
            set1.add(n);
        }

        for (int n : set1) {
            if (set.contains(n)) {
                r.add(n);
            }
        }
        int[] a = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            a[i] = r.get(i);
        }
        return a;

    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 9, 5};
        int[] b = new int[]{9, 4, 9, 8, 4};
        int[] c = intersection(a, b);
        for (int i : c) {
            System.out.print(i + ",");
        }
    }
}
