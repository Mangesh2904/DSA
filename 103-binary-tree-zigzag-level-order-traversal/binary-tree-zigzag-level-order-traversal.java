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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>>ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        int c = 0;
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode t = q.poll();
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);                
                l.add(t.val);
            }

            if((c & 1) == 1) Collections.reverse(l);
            ans.add(l);
            c++;
        }

        return ans;
    }
}