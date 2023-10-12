class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>(); // element , index
        for(int i = 0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0, inorder.length-1, postorder.length-1, inMap);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inS, int inE, int posIdx,
    Map<Integer, Integer> inMap) {
        if(inS > inE) return null;

        TreeNode root = new TreeNode(postorder[posIdx]);
        int mid = inMap.get(postorder[posIdx]);

        root.left = helper(inorder, postorder, inS, mid-1, posIdx - (inE - mid) -1, inMap); 
        // inE - mid = length of right subtree
        // if we subtract 'length of right subtree' from 'posIdx', we will be left with posIdx of left subtree...
        root.right = helper(inorder, postorder, mid+1, inE, posIdx -1, inMap);

        return root;
    }
}