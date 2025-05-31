class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length(),start=0, count=0;
        char[] c=new char[3];

        for(int end=0; end<n; end++){
            c[s.charAt(end)-'a']++;
            while(c[0]>0 && c[1]>0 && c[2]>0)
            {
                 count+= n-end;
                 c[s.charAt(start)-'a']--;
                 start++;
            }
        }
        return count;
    }
}