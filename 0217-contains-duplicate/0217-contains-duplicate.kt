class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hash = mutableSetOf<Int>()

        for(num in nums) {
            if(!hash.add(num)) return true
        }

        return false
    }
}