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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val > l2.val) {
            ListNode prevL1 = l2;
            l2 = l1;
            l1 = prevL1;
        }

        ListNode res = l1;
        ListNode prevL1 = null;

        while(l1 != null && l2 != null) {
            while(l1 != null && l1.val <= l2.val) {
                prevL1 = l1;
                l1 = l1.next;
            }

            prevL1.next = l2;

            // swap
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        return res;
    }
}