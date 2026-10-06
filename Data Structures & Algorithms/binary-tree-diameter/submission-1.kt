/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var maxDiameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return maxDiameter
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = dfs(root.left)
        val right = dfs(root.right)
        val sum = left + right
        maxDiameter = maxOf(maxDiameter, sum)

        return 1 + maxOf(left, right)
    }
}
