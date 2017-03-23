package gc.temp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个链表是否为回文链表
 * Created by guchao on 2017/3/23.
 *
 * @author guchao
 * @date 2017/03/23
 */
public class PalindromeLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {

        List<String> sb = new ArrayList<String>();

        if (null == head) {
            return true;
        }
        if (null == head.next) {
            return true;
        }

        for (ListNode nextNode = head; nextNode != null; nextNode = nextNode.next) {
            sb.add(String.valueOf(nextNode.val));
        }
        return isPalindrome(sb.toArray());


    }

    public boolean isPalindrome(Object[] str) {
        boolean result = true;

        int length = str.length;

        for (int i = 0, j = length - 1; i <= j; i++, j--) {
            String begin = (String) str[i];
            String end = (String) str[j];
            result = !begin.equals(end) ? false : true;
            if (!result) {
                return result;
            }
        }
        return result;
    }

    @Test
    public void PalindromeLinkedListTest() {
        int[] value = {1, 2, 3, 3, 2, 1};
        ListNode head = new ListNode(value[0]);
        ListNode next = head;
        for (int i = 1; i < value.length; i++) {
            ListNode tmp = new ListNode(value[i]);
            next.next = tmp;
            next = tmp;
        }
        next.next = null;

        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val + "----->>");
        }

        System.out.println(isPalindrome(head));
    }

}
