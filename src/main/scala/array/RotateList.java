package array;

/**
 * Created by guchao on 19/1/2.
 * leetcode 61
 */
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k < 0) return head;
        int length = 0;
        ListNode end = head;
        while (end != null) {
            length += 1;
            end = end.next;
        }
        end.next = head;
        k = k % length;
        ListNode newEnd = head;
        for(int i = 0;i<length-k-1;i++){
                newEnd = newEnd.next;
        }
        ListNode newHead= newEnd.next;
        newEnd.next = null;
        return newHead;
    }

    public static void main(String[] args) {

    }
}
