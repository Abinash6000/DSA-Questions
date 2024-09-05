/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        return reverseList(null, head, head.next);
    }

    private ListNode reverseList(ListNode prev, ListNode curr, ListNode next) {
        curr.next = prev;
        prev = curr;
        curr = next;

        if(next == null)
            return prev;
        
        next = next.next;
        return reverseList(prev, curr, next);
    }
}