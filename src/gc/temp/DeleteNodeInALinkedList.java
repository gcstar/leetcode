package gc.temp;

public class DeleteNodeInALinkedList {
	private static  ListNode root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteNodeInALinkedList linkedList = new DeleteNodeInALinkedList();
		int[] a = { 1, 2, 3, 4, 5 };
		 root = linkedList.createList(a, a.length);
		linkedList.printList(root);
		linkedList.deleteNode(1);
		System.out.println();
		linkedList.printList(root);
		System.out.println();
		linkedList.deleteNode(5);
		linkedList.printList(root);
		System.out.println();
		linkedList.deleteNode(1);
		linkedList.printList(root);
	}

	private ListNode deleteNode(int val) {
		ListNode tempNode = root;
		if (root.val == val) {
			root = root.next;
			return root;
		}
		ListNode preNode = tempNode;
		while (tempNode != null) {
			if (tempNode.val == val) {
				if (tempNode.next == null) {
					preNode.next = null;
					tempNode = null;
					break;
				} else {
					preNode.next = tempNode.next;
					tempNode = null;
					break;
				}
			} else {
				preNode = tempNode;
				tempNode = tempNode.next;
			}
		}
		return root;
	}

	private void printList(ListNode root) {
		while (root != null) {
			System.out.print(root.val + " - > ");
			root = root.next;
			if (root == null) {
				System.out.print("null");
			}
		}

	}

	public ListNode createList(int[] a, int length) {
		if (length == 0)
			return null;
		root = new ListNode(a[0]);
		ListNode node = root;
		for (int i = 1; i < length; i++) {
			ListNode tempNode = new ListNode(a[i]);
			node.next = tempNode;
			node = tempNode;
		}
		return root;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

}
