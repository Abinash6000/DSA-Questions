class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node l = root.left, r = root.right, n = root.next;
        if(l != null) {
            l.next = r;
            if(n != null)
                r.next = n.left;
            connect(l);
            connect(r);
        }
        
        return root;
    }
}