class Solution {
    int ans;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        this.k = k;
        helper(root);
        return ans;
    }

    private void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);
        if(k == 1) ans = root.val;
        k--;

        helper(root.right);

    }
}