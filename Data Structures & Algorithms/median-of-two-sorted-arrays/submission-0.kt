class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val left = (nums1.size + nums2.size + 1) / 2
        val right = (nums1.size + nums2.size + 2) / 2
        return (getKth(nums1, nums1.size, nums2, nums2.size, left) +
                getKth(nums1, nums1.size, nums2, nums2.size, right)) / 2.0
    }

    private fun getKth(a: IntArray, m: Int, b: IntArray, n: Int, k: Int, aStart: Int = 0, bStart: Int = 0): Int {
        if (m > n) {
            return getKth(b, n, a, m, k, bStart, aStart)
        }
        if (m == 0) {
            return b[bStart + k - 1]
        }
        if (k == 1) {
            return minOf(a[aStart], b[bStart])
        }

        val i = minOf(m, k / 2)
        val j = minOf(n, k / 2)

        return if (a[aStart + i - 1] > b[bStart + j - 1]) {
            getKth(a, m, b, n - j, k - j, aStart, bStart + j)
        } else {
            getKth(a, m - i, b, n, k - i, aStart + i, bStart)
        }
}
}