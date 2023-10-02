class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list, "");
        return list;
    }

    private void helper(TreeNode root, List<String> list, String path) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            path += root.val;
            list.add(path);
            return;
        }
        path += (root.val+"->");
        helper(root.left, list, path);
        helper(root.right, list, path);
    }
}