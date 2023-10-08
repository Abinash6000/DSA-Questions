class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while(size > 0) {
                TreeNode node = q.remove();
                if (flag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                size--;
            }
            ans.add(level);
            flag = !flag;
        }

        return ans;
    }
}