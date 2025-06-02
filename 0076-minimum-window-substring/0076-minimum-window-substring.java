class Solution {
    public String minWindow(String s, String t) {
        char[] mp = new char[100];
        HashSet<Character> hs = new HashSet<>();
        String res = "";
        int countChr = 0;
        for(char c : t.toCharArray()) {
            hs.add(c);
            mp[c-'A']++;
            if(mp[c-'A'] == 1) countChr++;
        }

        int st = 0, ed = 0;
        char[] sArr = s.toCharArray();
        while(ed < s.length()) {
            if(hs.contains(sArr[ed])) {
                mp[sArr[ed]-'A']--;
                if(mp[sArr[ed]-'A'] == 0)
                    countChr--;

                while(countChr == 0) {
                    if(res.length() == 0 || res.length() > (ed-st+1))
                        res = s.substring(st, ed+1);

                    if(hs.contains(sArr[st])) {
                        mp[sArr[st]-'A']++;
                        if(mp[sArr[st]-'A'] == 1) countChr++;
                    }
                    st++;
                }
            }

            ed++;
        }

        return res;
    }
}