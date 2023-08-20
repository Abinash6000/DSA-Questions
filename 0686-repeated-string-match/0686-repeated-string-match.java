class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        String s = "";
        while (s.length() < B.length()) {
            s += A;
            count++;
        }
        if(s.contains(B)) return count;
        if((s + A).contains(B)) return ++count;
        return -1;
    }
}