class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftH = getH(root.left);
        int rightH = getH(root.right);

        if(leftH == rightH) 
            return (1<<leftH) -1 +1 + countNodes(root.right);
        else
            return (1<<rightH) -1 +1 + countNodes(root.left);
    }
    
    private int getH(TreeNode root) {
        if(root == null) return 0;
        int h = 0;

        while(root != null) {
            h++;
            root = root.left;
        }

        return h;
    }
}