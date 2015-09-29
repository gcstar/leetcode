package gc.temp;

import java.util.ArrayList;
import java.util.List;

public class PreorderBinaryTree {
	/**
	 * Definition for a binary tree node.
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return list;
		list.add(root.val);
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left != null) {
			preorderTraversal(left);
		}
		if (right != null) {
			preorderTraversal(right);
		}
		return list;
	}
}
