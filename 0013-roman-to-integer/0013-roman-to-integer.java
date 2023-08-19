class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i), nextChar;

            if(i+1 != s.length()) {
                nextChar = s.charAt(i+1);

                if(hm.get(currChar) >= hm.get(nextChar)) sum += hm.get(currChar);
                else sum -= hm.get(currChar);
            } else {
                // just add the Roman
                sum += hm.get(currChar);
            }
        }

        return sum;
    }
}