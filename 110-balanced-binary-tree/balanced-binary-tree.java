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

    public int checkHeight(TreeNode root){
        if(root == null) return 0;

        else{

            int l = checkHeight(root.left);
            int r = checkHeight(root.right);

            if(l == -1 || r == -1) return -1;
            if(Math.abs(l - r) > 1) return -1;

            return 1 + Math.max(l, r);
        }
    }
    public boolean isBalanced(TreeNode root) {

        if(checkHeight(root) == -1) return false;
        return true;
        
    }
}