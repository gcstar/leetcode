package gc.temp;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        if (l1 == null) {
            node = l2;
        } else if (l2 == null) {
            node = l1;
        } else {
            if (l1.val < l2.val) {
                node = l1;
                node.next = mergeTwoLists(l1.next, l2);
            } else {
                node = l2;
                node.next = mergeTwoLists(l1, l2.next);
            }
        }
        return node;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
