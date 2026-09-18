/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val nodesMap = mutableMapOf<Node?, Node?>()
        var curr = head
        while (curr != null) {
            nodesMap[curr] = Node(curr.`val`)
            curr = curr?.next
        }

        curr = head
        while (curr != null) {
            val copy = nodesMap[curr]
            copy?.next = nodesMap[curr?.next]
            copy?.random = nodesMap[curr?.random]
            curr = curr?.next
        }
        return nodesMap[head]
    }
}
