class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while (root != null || !st.isEmpty()) {
            // Go to the leftmost node
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();          // process node
            res.add(root.val);

            root = root.right;        // move to right subtree
        }
        return res;
    }
}