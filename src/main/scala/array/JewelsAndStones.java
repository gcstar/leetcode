package array;

import java.util.HashMap;

/**
 * Created by guchao on 18/12/21.
 */
public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }

        int num = 0;

        for (char c : J.toCharArray()) {
            Integer count = map.get(c);
            if (count != null) {
                num += count;
            }
        }
        return num;

    }

    public static void main(String... args) {
        String J="aA";
        String S = "aAAbbbb";
        String z = "zZ";
        String Z ="aaaavbbada";
        System.out.println(numJewelsInStones(J,S));
        System.out.println(numJewelsInStones(z,Z));

    }
}
