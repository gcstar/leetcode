package gc.temp;

public class MajorityElement {

	public static void main(String[] args) {
		
	}

	public static int majorityElement(int[] nums) {
		shellSort(nums);
		return nums[nums.length/2];
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
