/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var list1 = head
        var half = findHalf(head)
        var list2 = reverseList(half)
        var newHead: ListNode? = null
        var current: ListNode? = list1
        while (list1 != null) {
            val nextNodeOnList1 = list1?.next
            list1?.next = list2
            list2 = list2?.next
            list1?.next?.next = nextNodeOnList1
            list1 = nextNodeOnList1
        }
    }

    fun findHalf(head: ListNode?): ListNode? {
        var a = head
        var b = head
        while (b?.next?.next != null) {
            a = a?.next
            b = b?.next?.next
        }
        val ret = a?.next
        println("Half at: ${ret?.`val`}")
        a?.next = null
        return ret
    }

    fun reverseList(list: ListNode?): ListNode? {

        var prev: ListNode? = null
        var current: ListNode? = list
        while (current != null) {
            val next = current?.next
            current?.next = prev
            prev = current
            current = next
        }
        return prev
    }
}
