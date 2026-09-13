/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private void swap(TreeNode n) {
        if (n == null) {
            return;
        }

        TreeNode temp = n.left;
        n.left = n.right;
        n.right = temp;

        swap(n.left);
        swap(n.right);
    }

    public TreeNode invertTree(TreeNode root) {
        swap(root);

        return root;
    }
}
