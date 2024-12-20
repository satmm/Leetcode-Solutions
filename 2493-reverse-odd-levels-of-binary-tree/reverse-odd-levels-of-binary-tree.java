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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        q.add(root);
        st.push(root.val);
        int i = 0;
        while(!q.isEmpty()) {
            Queue<TreeNode> q1 = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode node = q.remove();
                if(i % 2 != 0) {
                    node.val = st.pop();   
                }
                if(node.left != null) {
                    q1.add(node.left);
                    if(i % 2 == 0)
                        st.add(node.left.val);
                }
                if(node.right != null) {
                    q1.add(node.right);
                    if(i % 2 == 0)
                        st.add(node.right.val);
                }
            }
            q = q1;
            i++;
        }
        return root;
    }
}