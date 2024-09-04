class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for(char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        Pair[] counts = new Pair[hm.size()];
        int i = 0;
        for(Map.Entry<Character, Integer> e: hm.entrySet()) {
            counts[i++] = new Pair(e.getKey(), e.getValue());
        }

        Arrays.sort(counts, new CompareByValue());

        StringBuilder res = new StringBuilder();
        for(int j = 0; j<counts.length; j++) {
            int currCount = counts[j].count;
            char currLetter = counts[j].letter;
            for(int k = 0; k<currCount; k++) {
                res.append(currLetter);
            }
        }

        return res.toString();
    }
}

class CompareByValue implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return b.count - a.count;
    }
}

class Pair {
    char letter;
    int count;
    Pair(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }
}