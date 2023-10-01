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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>(); 
        // mapOf(hd, mapOf(level, listOfNodeValues at same level))
        q.add(new Tuple(0, 0, root));

        while(!q.isEmpty()) {
            Tuple tuple = q.remove();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            } if(!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).add(node.val);
            if(node.left != null) {
                q.add(new Tuple(x-1, y+1, node.left));
            } if(node.right != null) {
                q.add(new Tuple(x+1, y+1, node.right));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()) {
                while(!nodes.isEmpty()) {
                    System.out.println(nodes.peek());
                    list.get(list.size()-1).add(nodes.remove());
                }
            }
        }

        return list;
    }

    private class Tuple {
        int row; // hd
        int col; // level
        TreeNode node;

        Tuple(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }
}