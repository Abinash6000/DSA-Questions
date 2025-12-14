class Solution {
    fun numberOfWays(corridor: String): Int {
        val mod: Int = (1e9+7).toInt()
        var res = 1L; var j = 0; var k = 0;
        
        for(i in 0 until corridor.length) {
            if(corridor[i] == 'S') {
                if(++k > 2 && k % 2 == 1)
                    res = res * (i - j) % mod

                j = i
            }
        }

        return if(k % 2 == 0 && k > 0) res.toInt() else 0
    }
}