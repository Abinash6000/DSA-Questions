class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // mapof y, x, PQ(values)
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));

        while(!q.isEmpty()) {
            Tuple curr = q.remove();
            int x = curr.x, y = curr.y;
            TreeNode node = curr.node;

            if(!map.containsKey(y))
                map.put(y, new TreeMap<>());
            if(!map.get(y).containsKey(x))
                map.get(y).put(x, new PriorityQueue<>());
            map.get(y).get(x).add(node.val);

            if(node.left != null) 
                q.add(new Tuple(node.left, y-1, x+1));
            if(node.right != null)
                q.add(new Tuple(node.right, y+1, x+1));
        }

        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> xs : map.values()) {
            List<Integer> vertical = new ArrayList<>(); // for each vertical column
            for(PriorityQueue<Integer> nodes : xs.values()) {
                while(!nodes.isEmpty()) {
                    vertical.add(nodes.remove());
                }
            }
            res.add(vertical);
        }

        return res;
    }
}

class Tuple {
    TreeNode node;
    int y;
    int x;

    Tuple(TreeNode node, int y, int x) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}