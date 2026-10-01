/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val howManyNodes = countNodes(head)

        return reverseNodesRedundant(head, k, howManyNodes)
    }

    private fun reverseNodesRedundant(head: ListNode?, k: Int, nodesLeft: Int): ListNode? {
        var veryFirstPrev: ListNode? = null
        var prev: ListNode? = null
        var curr: ListNode? = head
        if (nodesLeft < k) {
            return head
        }
        var count = 0
        while (count < k) {
            val next = curr?.next
            curr?.next = prev
            prev = curr
            curr = next
            count += 1
            if (veryFirstPrev == null) {
                veryFirstPrev = prev
            }
        }
        veryFirstPrev?.next = reverseNodesRedundant(curr, k, nodesLeft - k)
        return prev
    }

    private fun reverseNodes(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = head
        while(curr != null) {
            val next = curr?.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }

    private fun countNodes(head: ListNode?): Int {
        var count = 0
        var curr = head
        while (curr != null) {
            count += 1
            curr = curr?.next
        }
        return count
    }
}
