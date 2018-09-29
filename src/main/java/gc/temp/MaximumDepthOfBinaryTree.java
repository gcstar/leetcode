package gc.temp;

public class MaximumDepthOfBinaryTree {

	public int MaxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int maxLeft = MaxDepth(root.left);
		int maxRight = MaxDepth(root.right);
		return maxLeft > maxRight ? maxLeft + 1 : maxRight + 1;
	}

	class TreeNode {
		int val;

		public TreeNode(int val) {
			this.val = val;
		}

		TreeNode left;
		TreeNode right;
	}

}
