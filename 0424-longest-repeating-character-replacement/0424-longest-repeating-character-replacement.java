class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int st = 0, ed = 0, n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>(); // char, count
        int maxFq = 0;

        while(ed < n) {
            hm.put(s.charAt(ed), hm.getOrDefault(s.charAt(ed), 0) + 1);
            maxFq = Math.max(maxFq, hm.get(s.charAt(ed)));

            int changes = (ed-st+1)-maxFq; // this gives us the number of changes
            if(changes > k) {
                hm.put(s.charAt(st), hm.get(s.charAt(st))-1);
                maxFq = 0;

                for(int fq : hm.values()) maxFq = Math.max(maxFq, fq);

                st++;
            }

            res = Math.max(res, ed-st+1);
            ed++;
        }

        return res;
    }
}