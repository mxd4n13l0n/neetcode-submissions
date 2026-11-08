/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (isSameTree(root, subRoot)) {
            return true
        }
        if (root?.left != null) {
            return isSubtree(root?.left, subRoot)
        }
        if (root?.right != null) {
            return isSubtree(root?.right, subRoot)
        }
        return false
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p?.`val` != q?.`val`) {
            return false
        }

        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}
