class Solution {
    fun countTrapezoids(points: Array<IntArray>): Int {
        val n = points.size; val MOD = 1000000007
        points.sortWith { a, b ->
            a[1].compareTo(b[1])
        }

        var res = 0L; var total = 0L; 
        var j = 0; var i = 0
        while(i < n) {
            j = i+1
            while(j < n && points[i][1] == points[j][1]) 
                j++

            val count = j-i
            val lines = (count.toLong() * (count - 1) /2)

            res = (res + total * lines) % MOD
            total = (total + lines) % MOD

            i = j
        }

        return res.toInt()
    }
}