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

//  recurrsive 
// class Solution {
//     public void inorder(TreeNode root, List<Integer> l){
//         if(root == null) return;

//         inorder(root.left, l);
//         l.add(root.val);
//         inorder(root.right, l);
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> l = new ArrayList<>();
//         inorder(root, l);
//         return l;
//     }

    
// }



// iterative 

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