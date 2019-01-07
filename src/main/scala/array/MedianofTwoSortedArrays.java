package array;

/**
 * Created by guchao on 19/1/4.
 */
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] nums = new int[len1 + len2];

        int i = 0, j = 0, k = 0;

        for (; i < len1 && j < len2; ) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }


        if (i < len1) {
            for (int p = i; p < len1; p++) {
                nums[k++] = nums1[p];
            }
        }
        if (j < len2) {
            for (int p = j; p < len2; p++) {
                nums[k++] = nums2[p];
            }
        }

        if ((len1 + len2) % 2 == 0) return (nums[(len1 + len2) / 2 - 1] + nums[(len1 + len2) / 2]) / 2d;
        else {
            return nums[(len1 + len2) / 2];
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
