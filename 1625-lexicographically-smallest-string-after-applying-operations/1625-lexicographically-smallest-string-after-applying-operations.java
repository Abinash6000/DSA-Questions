class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        return dfs(s, a, b, new HashSet<>());
    }

    private String dfs(String s, int a, int b, Set<String> seen) {
        String smallest = s;
        if(seen.add(s)) {
            char[] ca = s.toCharArray();
            for(int i = 1; i<ca.length; i+=2) {
                ca[i] = (char)((ca[i] - '0' + a ) % 10 + '0');
            }

            String addA = dfs(String.valueOf(ca), a, b, seen);
            String rotate = dfs(s.substring(b) + s.substring(0,b), a, b, seen);
            for(String candidate : new String[]{addA, rotate}) {
                if(smallest.compareTo(candidate) > 0) {
                    smallest = candidate;
                }
            }
        }

        return smallest;
    }
}