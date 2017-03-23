package gc.array;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		int length = A.length;
		int removed = 0;
		if (A == null || A.length <= 0) {
			return 0;
		}
		int i = 0, j = 1;
		for (; i < A.length && j < A.length;) {
			if (A[i] == A[j]) {
				removed++;
				j++;
			} else if (A[i] < A[j]) {
				A[++i] = A[j];
				j++;
			}
		}
		return length - removed;
	}

	@Test
	public void test() {
		int[] a = new int[] { 1, 1, 1, 2, 3, 4, 4, 5 ,5,6,7,7,8,8,9,9,9,9,9,9,9,9,10,11,11};
		System.out.println(removeDuplicates(a));
        System.out.println("test");
	}
}
