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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return head.next;

        ListNode hare = head.next.next;
        ListNode tortoise = head;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        tortoise.next = tortoise.next.next;
        return head;
    }
}