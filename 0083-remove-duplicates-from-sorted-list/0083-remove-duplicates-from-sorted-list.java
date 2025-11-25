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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;

        ListNode res = head;

        while(head != null) {
            while(head.next != null && head.next.val == head.val)
                head.next = head.next.next;

            head = head.next;
        }

        return res;
    }
}