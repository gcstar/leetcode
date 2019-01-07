package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by guchao on 18/12/28.
 * leetcode 23
 */
public class MergekSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode n = queue.remove();
            if (n.next != null) {
                queue.add(n.next);
            }
            temp.next = n;
            temp = n;

        }
        return head.next;

    }

    public static void main(String[] args) {

        ListNode L1 = new ListNode(1);
        ListNode L2 = new ListNode(4);
        ListNode L3 = new ListNode(5);
        L1.next = L2;
        L2.next = L3;
        ListNode K1 = new ListNode(1);
        ListNode K2 = new ListNode(3);
        ListNode K3 = new ListNode(4);
        K1.next = K2;
        K2.next = K3;

        ListNode[] lists = new ListNode[]{L1, K1};
        ListNode head = mergeKLists(lists);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }


    }
}
