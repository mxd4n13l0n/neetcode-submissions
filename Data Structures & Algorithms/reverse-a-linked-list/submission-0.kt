/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head
        while (current != null) {
            val next = current?.next
            current?.next = prev
            prev = current
            current = next
        }
        return prev
    }
}

/*
0->1->2->3

reverse = 0
next = 1
mext2 = 2
1 -> 0
*/