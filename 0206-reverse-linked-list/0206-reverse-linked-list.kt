/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var (prev, curr, next) = Triple<ListNode?, ListNode?, ListNode?>(null, head, head?.next)

        if(curr == null)
            return head

        while(curr != null) {
            curr.next = prev
            prev = curr
            curr = next
            next = next?.next
        }

        return prev
    }
}