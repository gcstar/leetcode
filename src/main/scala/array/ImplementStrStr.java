package array;

/**
 * Created by guchao on 18/12/24.
 */
public class ImplementStrStr {
    public static int trick(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        return haystack.indexOf(needle);
    }

    public static int kms(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {

        System.out.println(trick("aaab","cab"));

    }
}
