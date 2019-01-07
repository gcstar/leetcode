package array;

/**
 * Created by guchao on 18/12/21.
 */
public class ReverseString {
    public static String reverseString(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return new String(c);

    }

    public static void main(String[] args) {
        System.out.println(reverseString("A man, a plan, a canal: Panama"));
    }
}
