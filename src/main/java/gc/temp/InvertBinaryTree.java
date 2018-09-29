package gc.temp;

public class InvertBinaryTree {

	public static void main(String[] args) {
	}
	
	public static TreeNode invert(TreeNode root){
		if(root == null) return null;
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = right;
		root.right = left;
		invert(left);
		invert(right);
		return root;
	}
	/**
	 * Definition for a binary tree node.
	 */
	   class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
}
