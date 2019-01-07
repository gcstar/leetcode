package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guchao on 18/12/28.
 * leetcode 24
 */
//TODO
public class SwapNodesinPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        List<ListNode[]> list = new ArrayList();
        ListNode temp = head;

        while (temp != null) {
            ListNode[] arr = new ListNode[2];

            if (temp != null && temp.next != null) {
                arr[0] = temp.next;
                arr[0].next = null;
                arr[1] = temp;
                temp = temp.next.next;
            } else if (temp.next == null) {
                arr[0] = temp;
                arr[0].next =null;
                temp = temp.next;
            }
            list.add(arr);
        }
        ListNode h = list.get(0)[0];
        ListNode t = h;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (list.get(0)[1] != null) {
                    ListNode node = list.get(0)[1];
                    t.next = node;
                    t = node;
                }
            } else {
                for (ListNode n : list.get(i)) {
                    if (n != null) {
                        t.next = n;
                        t = n;
                    } else if (n == null) {
                        t.next = null;
                    }
                }

            }
        }

        return h;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode node = swapPairs(head);

        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }


    }
}
