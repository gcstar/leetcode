package array;

/**
 * Created by guchao on 18/12/21.
 */
public class NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i] == '0' ? '1' : '0';
        }
        return Integer.parseInt(new String(chars), 2);

    }
}
