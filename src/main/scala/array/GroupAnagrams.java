package array;

import java.util.*;

/**
 * Created by guchao on 18/12/28.
 * leetcode 49
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        Map<String, List<String>> map = new HashMap();

        for (String str : strs) {
            String key = getKey(str);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
            } else {
                List list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> result = new ArrayList();

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    public static String getKey(String str1) {
        char[] chars = str1.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        List<List<String>> list = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> l : list) {
            for (String s : l) {
                System.out.print(s + ",");
            }
            System.out.println();
        }
    }
}
