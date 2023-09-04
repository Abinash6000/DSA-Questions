class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        morrisTraversal(root, list);
        return list;
    }

    private void morrisTraversal(TreeNode root, List<Integer> list) {
        TreeNode curr, pre; // current and predecessor
        curr = root;
        while(curr != null) {
            if(curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                    while(pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if(pre.right == null) {
                    pre.right = curr;
                    list.add(curr.val);
                    curr = curr.left;
                } else {
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
    }
}