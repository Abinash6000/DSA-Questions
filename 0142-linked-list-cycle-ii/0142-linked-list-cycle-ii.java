
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode tortoise = head.next, hare = head.next.next;
        while(tortoise != hare) {
            if(hare == null || hare.next == null) {
                ListNode res = null;
                return res;
            }
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        ListNode tortoise2 = head;
        while(tortoise2 != tortoise) {
            tortoise2 = tortoise2.next;
            tortoise = tortoise.next;
        }
        return tortoise2;
    }
}