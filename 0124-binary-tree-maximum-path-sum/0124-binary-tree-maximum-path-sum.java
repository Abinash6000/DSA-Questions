class Solution {
    int maxPath;
    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        helper(root);
        return maxPath;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        maxPath = Math.max(maxPath, 
        Math.max(leftSum + root.val, 
        Math.max(rightSum + root.val, 
        Math.max(leftSum + rightSum + root.val, root.val))));

        return Math.max(leftSum + root.val, Math.max(rightSum + root.val, root.val));
    }
}