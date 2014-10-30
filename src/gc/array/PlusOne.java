package gc.array;

import java.util.Arrays;

import org.junit.Test;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits.length <= 0 || digits == null) {
			return null;
		}
		int length = digits.length;
		int[] result = new int[length + 1];
		for (int i = 0; i < length; i++) {
			result[i + 1] = digits[i];
		}
		digits[length - 1] = digits[length - 1] + 1;
		if (digits[length - 1] < 10) {
			return digits;
		} else {
			result[length] = 0;
			for (int i = length-1; i >= 0; i--) {
				result[i] += 1;
				if (result[i] == 10) {
					result[i] = 0;
					continue;
				} else {
					break;
				}
			}
		}
		if(result[0] == 0){
			result = Arrays.copyOfRange(result, 1, length+1);
		}
		return result;
	}

	@Test
	public void test() {
		int[] a = new int[] { 8, 9, 9, 9, 9,9,9,9 };
		int[] res = plusOne(a);
		for (int i : res) {
			System.out.print(i);
		}
	}
}
