/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var head: ListNode? = null
        var current: ListNode? = null
        var a = list1
        var b = list2
        while (a != null || b != null) {
            val aVal = a?.`val` ?: 101
            val bVal = b?.`val` ?: 101
            var selection: ListNode? = null
            if (aVal < bVal) {
                selection = a
                a = a?.next
            } else {
                selection = b
                b = b?.next
            }
            if (head == null) {
                head = selection
                current = selection
            } else {
                current?.next = selection
                current = current?.next
            }
        }
        return head
    }
}
