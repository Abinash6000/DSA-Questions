class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i<preorder.length; i++) {
            insert(root, preorder[i]);
        }

        return root;
    }

    private void insert(TreeNode root, int val) {
        if(root.val > val && root.left == null) {
            root.left = new TreeNode(val);
            return;
        }
        if(root.val < val && root.right == null) {
            root.right = new TreeNode(val);
            return;
        }

        if(root.val > val) insert(root.left, val);
        else if(root.val < val) insert(root.right, val);
    }
}