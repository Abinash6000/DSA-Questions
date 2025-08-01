class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
                while(pre.right != curr && pre.right != null) 
                    pre = pre.right;

                if(pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else { // pre.right == curr
                    pre.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}