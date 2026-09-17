/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null || head?.next == null) {
            return false
        }
        var a = head
        var b = head
        while (a != null && b != null) {
            a = a?.next
            b = b?.next?.next
            if (a == b) {
                return true
            }
        }
        return false
    }
}
