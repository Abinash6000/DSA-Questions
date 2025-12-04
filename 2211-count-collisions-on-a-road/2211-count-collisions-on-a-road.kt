class Solution {
    fun countCollisions(directions: String): Int {
        var cols = 0

        var st = 0; var ed = directions.length-1
        while(st <= ed)
            if(directions[st] == 'L') {
                st++
                continue
            } else
                break

        while(ed >= st)
            if(directions[ed] == 'R') {
                ed--
                continue
            } else
                break

        while(st <= ed) {
            if(directions[st] == 'L' || directions[st] == 'R') 
                cols++

            st++
        }

        return cols
    }
}