/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val length = findLength(head)
        val target = length - n
        var count = 0
        if (count == target) {
            return head?.next
        }

        var curr = head
        var prev: ListNode? = null
        while (count < target) {
            prev = curr
            curr = curr?.next
            count += 1
        }
        prev?.next = curr?.next
        return head
    }

    private fun findLength(head: ListNode?): Int {
        var curr = head
        var n = 0
        while (curr != null) {
            n += 1
            curr = curr?.next
        }
        return n
    }
}
