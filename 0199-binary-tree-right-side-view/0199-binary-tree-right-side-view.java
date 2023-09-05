class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, 1, list);
        return list;
    }

    private void preOrder(TreeNode root, int depth, List<Integer> list) {
        if(root == null) return;

        if(depth > list.size()) {
            list.add(root.val);
        }

        preOrder(root.right, depth+1, list);
        preOrder(root.left, depth+1, list);
    } 
}