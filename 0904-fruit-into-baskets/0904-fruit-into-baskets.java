class Solution {
    public int totalFruit(int[] fruits) {
        int maxF = 0;
        HashMap<Integer, Integer> hm = new HashMap<>(); // type, count
        int st = 0, ed = 0;
        
        while(ed < fruits.length) {
            hm.put(fruits[ed], hm.getOrDefault(fruits[ed], 0) + 1);

            if(hm.size() <= 2) {
                maxF = Math.max(maxF, ed-st+1);
            } else {
                hm.put(fruits[st], hm.get(fruits[st])-1);
                if(hm.get(fruits[st]) == 0) hm.remove(fruits[st]);
                st++;
            }

            ed++;
        }

        return maxF;
    }
}