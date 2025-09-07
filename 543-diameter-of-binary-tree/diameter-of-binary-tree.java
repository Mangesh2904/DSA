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
    public int checkHeight(TreeNode root, int[] max){
        if(root == null) return 0;

        else{

            int l = checkHeight(root.left, max);
            int r = checkHeight(root.right, max);
            max[0] = Math.max(l + r, max[0]);

            return 1 + Math.max(l, r);
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        checkHeight(root, max);
        return max[0];
    }
}