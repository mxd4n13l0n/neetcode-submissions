/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return calculateMaxDepth(root, 1)
    }

    private fun calculateMaxDepth(root: TreeNode?, depth: Int): Int {
        if (root == null) {
            return depth - 1
        }
        val newDepth = depth + 1
        println("current node is: ${root?.`val`} and depth is ${depth}")
        return Math.max(
            calculateMaxDepth(root?.left, newDepth),
            calculateMaxDepth(root?.right, newDepth),
        )
    }
}
