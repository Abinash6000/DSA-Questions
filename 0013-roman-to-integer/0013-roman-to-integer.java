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
            char currChar = s.charAt(i), nextChar = 'a';

            if(i+1 != s.length()) {
                nextChar = s.charAt(i+1);

                int currVal = hm.get(currChar);
                int nextVal = hm.get(nextChar);

                if(currVal >= nextVal) sum += currVal;
                else sum -= currVal;

            } else {
                sum += hm.get(currChar);
            }

        }

        return sum;
    }
}