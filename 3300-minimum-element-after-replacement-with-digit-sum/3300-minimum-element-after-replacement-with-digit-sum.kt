class Solution {
    fun minElement(nums: IntArray): Int {
        var minRes = Int.MAX_VALUE

        for(i in 0 until nums.size) {
            val num = nums[i]

            nums[i] = sumOfDigits(num)
            minRes = min(minRes, nums[i])
        }

        return minRes
    }

    fun sumOfDigits(num: Int): Int {
        var sum = 0
        var n = num

        while(n > 0) {
            sum += n % 10
            n /= 10
        }

        return sum
    }
}