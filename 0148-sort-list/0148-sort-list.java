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
    public ListNode sortList(ListNode head) {
        return divide(head);
    }

    private ListNode divide(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode midHead = mid.next;
        mid.next = null;


        head = divide(head);
        midHead = divide(midHead);

        return conquer(head, midHead);
    }

    private ListNode conquer(ListNode list1, ListNode list2) { // this is same as merging two sorted LL
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        if(list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyNode.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head.next;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        return tortoise;
    }
}