// my sol
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        ListNode lastNode = null;
        while(curr != null) {
            if(curr.next == null) lastNode = curr;
            curr = curr.next;
            size++;
        }
        if(head == null || k == 0 || k%size == 0) return head;
        k = k%size;
        int sizeTillBreak = size - k;
        curr = head;
        while(sizeTillBreak-- != 1) {
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        lastNode.next = head;
        return newHead;
    }
}