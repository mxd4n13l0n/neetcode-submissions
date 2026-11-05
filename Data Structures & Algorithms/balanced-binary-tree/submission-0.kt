/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var isBalanced = true
    fun isBalanced(root: TreeNode?): Boolean {
        computeHeights(root, 0)
        return isBalanced
    }

    fun computeHeights(root: TreeNode?, level: Int): Int {
        if (root == null) {
            return level - 1
        }
        println("computing height on: ${root.`val`}")
        val left = computeHeights(root?.left, level + 1)
        val right = computeHeights(root?.right, level + 1)
        println("left: ${left}")
        println("right: ${right}")
        if (left - right > 1 || right - left > 1) {
            isBalanced = false
        }
        return maxOf(left, right)
    }
}
