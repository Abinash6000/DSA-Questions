class Solution {
    public Node connect(Node root) {

        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            Node currNode = null;

            while(size != 0) {
                currNode = q.poll();
                currNode.next = q.peek();

                if(currNode.left != null) q.offer(currNode.left);
                if(currNode.right != null) q.offer(currNode.right);
                size--;
            }

            currNode.next = null;
        }

        return root;
    }
}