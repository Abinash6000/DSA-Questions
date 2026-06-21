class Solution {
    fun isValid(s: String): Boolean {
        var res = true
        val st = ArrayDeque<Char>()
        val hm = mapOf<Char, Char>('(' to ')', '{' to '}', '[' to ']')

        for(char in s) {
            if(hm.containsKey(char))
                st.addLast(char)
            else {
                val top = st.removeLastOrNull()
                if(hm[top] != char)
                    return false
            }
        }

        if(!st.isEmpty) res = false

        return res
    }
}