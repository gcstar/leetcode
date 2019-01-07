package array;

import java.util.Stack;

/**
 * Created by guchao on 19/1/4.
 * leetcode 101
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode s = stack.pop(), t = stack.pop();
            if (s == null && t == null) continue;
            if (s == null || t == null) return false;
            if (s.val != t.val) return false;
            stack.push(s.left);
            stack.push(t.right);
            stack.push(s.right);
            stack.push(t.left);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
