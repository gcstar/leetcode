package array;

/**
 * Created by guchao on 18/12/21.
 */
public class FindtheDifference {
    public static char findTheDifference(String s, String t) {
        int i = 0;
        int j = 0;
        for (char a : s.toCharArray()) {
            i = i + (int) a;
        }
        for (char a : t.toCharArray()) {
            j = j + (int) a;
        }

        return (char) (j - i);
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd","abcde"));
    }
}
