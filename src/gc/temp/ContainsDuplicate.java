package gc.temp;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 51, 1, 34, 2, 34, 22, 45, 52, 345, 213, 452342 };
		System.out.println(containsDuplicate(a));
		shellSort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	// 1. bad ,take O(n ^2)
	// 2 . not good ,first shell sort ,the find the duplicate element
	public static boolean containsDuplicate(int[] nums) {
		shellSort(nums);
		boolean result = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return result;
	}

	private static void shellSort(int[] a) {
		int length = a.length;
		int n = 1;
		while (n < length / 3) {
			n = n * 3 + 1;
		}

		while (n >= 1) {
			for (int i = n; i < a.length; i++) {
				for (int j = i; j >= n && a[j] < a[j - n]; j -= n) {
					int temp = a[j];
					a[j] = a[j - n];
					a[j - n] = temp;
				}
			}
			n = n / 3;
		}
	}

}
