package array;

/**
 * Created by guchao on 18/12/19.
 */
public class SortArrayByParityIIJava {
    public static int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int length = A.length;
        while (i < length && j < length) {
            while (i < length && !isOdd(A[i])) {
                i += 2;
            }
            while (j < length && isOdd(A[j])) {
                j += 2;
            }

            if (i < A.length && j < A.length) {

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return A;

    }

    public static boolean isOdd(int num) {
        return num % 2 == 1 ? true : false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 1, 4, 0, 0, 4, 3, 3};
        a = sortArrayByParityII(a);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
