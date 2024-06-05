class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node iter = head;
         
        // First round: make copy of each node
        // and link them together side-by-side in a single list.
        while(iter != null) {
            Node copy = new Node(iter.val);
            copy.next = iter.next;
            iter.next = copy;
            iter = iter.next.next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while(iter != null)  {
            if(iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list
        iter = head;
        Node newHead = head.next, copy;
        while(iter.next != null) {
            copy = iter.next;
            iter.next = iter.next.next;
            if(copy.next == null) break;
            copy.next = copy.next.next;
            iter = iter.next;
        }
        return newHead;
    }
}