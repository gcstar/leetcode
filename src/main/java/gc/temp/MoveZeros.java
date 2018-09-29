package gc.temp;

public class MoveZeros {
	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 3, 12, 99, 3, 0 };
		moveZeros(a, a.length);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void moveZeros(int[] a, int length) {
		for (int i = 1; i < length; i++) {
			for (int j = i; j > 0 && (a[j] - a[j - 1]) == a[j]; j--) {
				change(a, j, j - 1);
			}
		}
	}

	private static void change(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
