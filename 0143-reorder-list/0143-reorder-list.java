class Solution {
    public void reorderList(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;

        while(hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        ListNode head2 = turtle.next;
        turtle.next = null;
        ListNode head1 = head;

        head2 = reverseLL(head2);

        while(head1 != null && head2 != null) {
            ListNode next = head1.next;
            head1.next = head2;
            head1 = next;

            next = head2.next;
            head2.next = head1;
            head2 = next;
        }
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}