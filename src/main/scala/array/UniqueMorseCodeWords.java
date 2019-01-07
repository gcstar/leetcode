package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by guchao on 18/12/21.
 * leetcode 804
 */
public class UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] moss =
                new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                        ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
                        "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String s = "abcdefghijklmnopqrstuvwxyz";
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(moss[s.indexOf(c)]);
            }
            set.add(sb.toString());
        }

        return set.size();

    }

    public static void main(String[] args) {

        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));

    }
}
