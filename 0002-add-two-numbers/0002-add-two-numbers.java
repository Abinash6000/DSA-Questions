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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2; 
        if(l2==null) return l1;
        ListNode head =new  ListNode(0);
        ListNode temp = head;
        int carry=0;
        while(l1 !=null || l2 !=null || carry !=0){
            int n1 = l1==null?0:l1.val;
            int n2 = l2==null?0:l2.val;
            int sum = n1 +n2 + carry;
            carry=0;
            if(sum>=10) carry =1; 
            sum = sum %10; 
            ListNode t = new ListNode(sum);
            temp.next =t;
            temp=temp.next;
            if(l1!=null )
            l1 = l1.next;
            if(l2!=null)
            l2 = l2.next;
        }
        return head.next;
        
    }
}