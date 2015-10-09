package gc.temp;

public class RemoveDuplcateElement {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = null;
		ListNode preNode = null;
		if (head == null || head.next == null) {
			return head;
		}
		preNode = head;
		node = preNode.next;
		while (node != null) {
			if (preNode.val == node.val) {
				preNode.next = node.next;
				node = node.next;
				continue;
			}
			preNode = node;
			node = node.next;
		}
		return head;
	}
}
