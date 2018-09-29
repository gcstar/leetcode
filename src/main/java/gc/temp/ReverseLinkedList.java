package gc.temp;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        ListNode node = null;
        ListNode preNode = null;
        if(head == null || head.next == null){
            return head;
        }
        preNode = head;
        node = preNode.next;
        while(node!=null){
            ListNode temp = node.next;
            node.next = preNode;
            preNode = node;
            node = temp;
        }
        head.next = null;
        return preNode;
    }
}
