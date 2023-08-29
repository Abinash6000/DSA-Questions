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
        List<Integer> list = new ArrayList<Integer>();
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode currNode = root;
        if(root != null) st.push(root);

        while(!st.isEmpty()) {
            if(currNode != null) currNode = currNode.left;
            while(currNode != null) {
                st.push(currNode);
                currNode = currNode.left;
            }
            
            currNode = st.pop();
            list.add(currNode.val);
            currNode = currNode.right;
            if(currNode != null) st.push(currNode);
        }
        return list;
    }
}