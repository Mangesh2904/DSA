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
    int max = 0;
    public int checkHeight(TreeNode root){
        if(root == null) return 0;

        else{

            int l = checkHeight(root.left);
            int r = checkHeight(root.right);
            max = Math.max(l + r, max);

            return 1 + Math.max(l, r);
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // int[] max = new int[1];
        checkHeight(root);
        return max;
    }
}