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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode n = root;

        while(true){
            
            if(n != null){
                st.push(n);
                n = n.left;
            } 

            else{
                if(st.isEmpty()) break;
                
                n = st.pop();
                l.add(n.val);
                n = n.right;
            }
            
        }
        return l;

    }
}