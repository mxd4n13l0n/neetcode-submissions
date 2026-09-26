/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.size == 0) {
            return null
        }
        var result: ListNode? = lists[0]
        for (i in 1..lists.lastIndex) {
            result = mergeTwoLists(result, lists[i])
        }
        return result
    }

    private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var head: ListNode? = null
        var pointer: ListNode? = null
        var a: ListNode? = list1
        var b: ListNode? = list2
        while (a != null || b != null) {
            var current: ListNode? = null
            if (a == null) {
                current = b
                b = b?.next
            } else if (b == null) {
                current = a
                a = a?.next
            } else {
                if (a?.`val`!! >= b?.`val`!!) {
                    current = b
                    b = b?.next
                } else {
                    current = a
                    a = a?.next
                }
            }
            if (head == null) {
                head = current
            }
            if (pointer == null) {
                pointer = current
            } else {
                pointer?.next = current
                pointer = pointer?.next
            }
        }
        return head
    }
}
