class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode h1 = head;
        ListNode prev1 = null;
        ListNode h2 = head;
        while (h2!=null && h2.next!=null) {
            ListNode next = h1.next;
            h2 = h2.next.next;
            h1.next = prev1;
            prev1 = h1;
            h1 = next;
        }
        if (h2!=null) h1=h1.next;
        while (h1!=null) {
            if (h1.val!=prev1.val) return false;
            h1=h1.next;
            prev1=prev1.next;
        }
        return true;
    }
}