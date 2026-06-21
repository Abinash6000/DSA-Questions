class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hm = mutableMapOf<Int, Int>()
        val res = IntArray(2)
        
        for(i in 0 until nums.size) {
            val toFind = target - nums[i]

            if(hm.contains(toFind)) {
                res[0] = hm.get(toFind) ?: 0
                res[1] = i
                return res;
            }

            hm.put(nums[i], i)
        }

        return res
    }
}