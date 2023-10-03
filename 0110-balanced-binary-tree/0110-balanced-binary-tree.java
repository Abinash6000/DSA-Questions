class Solution {
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return balanced;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int leftH = helper(root.left);
        int rightH = helper(root.right);
        if(Math.abs(leftH-rightH) >= 2) balanced = false;
        return 1+Math.max(leftH, rightH);
    }
}