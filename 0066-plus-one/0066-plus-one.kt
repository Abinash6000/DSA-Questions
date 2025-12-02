class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var res: MutableList<Int> = mutableListOf()
        val n = digits.size

        var car = 1
        for(i in n-1 downTo 0) {
            val dig = digits[i]+car
            car = (dig) / 10

            res.add(0, dig%10)
        }

        if(car == 1)
            res.add(0, car)

        return res.toIntArray()
    }
}