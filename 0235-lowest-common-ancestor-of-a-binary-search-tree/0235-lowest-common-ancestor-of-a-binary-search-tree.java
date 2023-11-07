class Solution {
    TreeNode ans = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }

    boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;
        
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);

        if(left && right) {
            ans = root;
            return false;
        } else if((left || right) && (root.val == p.val || root.val == q.val)) {
            ans = root;
            return false;
        } else if(left || right) {
            return true;
        } else if(root.val == p.val || root.val == q.val) { // the left and right is false here
            return true;
        } else { // the left and right and root are false
            return false;
        }
    }
}