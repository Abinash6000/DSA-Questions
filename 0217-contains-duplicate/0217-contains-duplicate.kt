class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hash = mutableSetOf<Int>()

        for(num in nums) {
            if(hash.contains(num)) return true
            hash.add(num)
        }

        return false
    }
}