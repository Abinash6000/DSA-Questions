class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        solve(l, n, n, "");
        return l;
    }
    private void solve(List<String> l, int o, int c, String op) {
        if (c==0) {
            l.add(op);
            return;
        }
        if(o<c) solve(l, o, c-1, op+")");
        if(o!=0) solve(l, o-1, c, op+"(");
    }
}