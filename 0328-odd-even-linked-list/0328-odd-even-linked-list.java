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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode tempOddHead = oddHead, tempEvenHead = evenHead;

        ListNode lastOddNode = null;
        while(tempOddHead != null && tempOddHead.next != null) {
            lastOddNode = tempOddHead;
            tempOddHead.next = tempOddHead.next.next;
            if(tempEvenHead.next != null)
                tempEvenHead.next = tempEvenHead.next.next;

            tempOddHead = tempOddHead.next;
            tempEvenHead = tempEvenHead.next;
        }

        if(tempOddHead != null) 
            lastOddNode = tempOddHead;

        lastOddNode.next = evenHead;
        return oddHead;
    }
}