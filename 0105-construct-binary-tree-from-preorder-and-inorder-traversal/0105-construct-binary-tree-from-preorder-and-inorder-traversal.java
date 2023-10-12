/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>(); // element, index
        for(int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(preorder, inorder, 0, preorder.length-1, 0, map);
    }

    private TreeNode construct(int[] preorder, int[] inorder, 
    int inS, int inE, int prIdx,
    Map<Integer, Integer> map) {

        if(inS > inE) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prIdx]);
        int mid = map.get(preorder[prIdx]);

        root.left = construct(preorder, inorder, inS, mid-1, prIdx + 1, map);
        root.right = construct(preorder, inorder, mid+1, inE, prIdx + mid - inS + 1, map); 
        // mid - inS == numbers on the left

        return root;
    }
}