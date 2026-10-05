/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val left = root?.left
        val right = root?.right
        root?.left = invertTree(right)
        root?.right = invertTree(left)
        return root
    }
}
