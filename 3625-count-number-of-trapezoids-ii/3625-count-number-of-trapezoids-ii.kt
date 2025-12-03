class Solution {
    fun countTrapezoids(points: Array<IntArray>): Int {
        val n = points.size; val inf = 1e9 + 7
        val slopeToIntercepts = mutableMapOf<Double, MutableList<Double>>()
        val midToSlopes = mutableMapOf<Int, MutableList<Double>>()
        var ans = 0

        for(i in 0 until n) {
            val x1 = points[i][0]; val y1 = points[i][1]

            for(j in i+1 until n) {
                val x2 = points[j][0]; val y2 = points[j][1]
                val dx = x1-x2; val dy = y1 - y2

                var m: Double // slope
                var c: Double // intercept

                if(x2 == x1) {
                    m = inf
                    c = x1.toDouble()
                } else {
                    m = (1.0 * (y2 - y1)) / (x2 - x1)
                    c = (1.0 * (y1 * dx - x1 * dy)) / dx
                }

                if(m == -0.0)
                    m = 0.0
                if(c == -0.0)
                    c = 0.0

                val mid = (x1 + x2) * 10000 + (y1 + y2)
                slopeToIntercepts
                    .getOrPut(m) { mutableListOf() }.add(c)
                midToSlopes
                    .getOrPut(mid) { mutableListOf() }.add(m)
            }
        }

        for(intercepts in slopeToIntercepts.values) {
            if(intercepts.size == 1)
                continue

            val countOfSameIntercept = sortedMapOf<Double, Int>()
            for(c in intercepts)
                countOfSameIntercept[c] = (countOfSameIntercept[c] ?: 0 ) + 1

            var sum = 0
            for(count in countOfSameIntercept.values) {
                ans += sum * count
                sum += count
            }
        }

        for(slopes in midToSlopes.values) {
            if(slopes.size == 1)
                continue

            val countOfSameSlope = sortedMapOf<Double, Int>()
            for(m in slopes)
                countOfSameSlope[m] = (countOfSameSlope[m] ?: 0) + 1

            var sum = 0
            for(count in countOfSameSlope.values) {
                ans -= sum * count
                sum += count
            }
        }

        return ans
    }
}