class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var (s, e) = Pair(0, 0)
        var sum = nums[0]
        var minLen = nums.size+1

        while(e < nums.size) {
            while(sum >= target) {
                minLen = min(minLen, e-s+1)
                sum -= nums[s]
                s++
            }

            e++;
            if(e < nums.size)
                sum += nums[e]
        }

        return if(minLen < nums.size+1) 
            minLen
        else
            0
    }
}