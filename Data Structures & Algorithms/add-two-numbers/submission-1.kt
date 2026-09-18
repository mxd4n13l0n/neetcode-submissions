/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result = ListNode(0)
        var current: ListNode? = result
        var num1 = l1
        var num2 = l2
        var remainder = 0
        while (num1 != null || num2 != null || remainder > 0) {
            val a = num1?.`val` ?: 0
            val b = num2?.`val` ?: 0
            val sum = a + b + remainder
            val newRemainder = sum / 10
            val realValue = sum % 10
            remainder = newRemainder
            current?.`val` = realValue
            num1 = num1?.next
            num2 = num2?.next
            if (num1 == null && num2 == null && remainder == 0) {
                break
            }
            current?.next = ListNode(0)
            current = current?.next
        }
        return result
    }
}
