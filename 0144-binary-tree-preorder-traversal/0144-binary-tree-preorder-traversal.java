class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode currNode = root;
        List<Integer> list = new ArrayList<>();
        
        while(currNode != null || !st.empty()) {
            while(currNode != null) {
                st.push(currNode);
                list.add(currNode.val);
                currNode = currNode.left;
            }

            currNode = st.pop();
            currNode = currNode.right;
        }

        return list;
    }
}