/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val current = root!!.`val`
        if (current == p!!.`val` || current == q!!.`val`) {
            return root
        }
        if (current > p!!.`val` && current > q!!.`val`) {
            return lowestCommonAncestor(root?.left, p, q)
        } else if (current < p!!.`val` && current < q!!.`val`) {
            return lowestCommonAncestor(root?.right, p, q)
        } else {
            return root
        }

    }
}
