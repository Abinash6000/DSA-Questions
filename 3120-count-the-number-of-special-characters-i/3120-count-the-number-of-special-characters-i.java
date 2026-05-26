class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> lower = new HashSet<>();
        HashSet<Character> upper = new HashSet<>();
        HashSet<Character> unique = new HashSet<>();

        for(char c : word.toCharArray()) {
            if(Character.isLowerCase(c))
                lower.add(c);
            else if(Character.isUpperCase(c))
                upper.add(c);

            if(lower.contains(Character.toLowerCase(c)) && upper.contains(Character.toUpperCase(c)))
                unique.add(Character.toLowerCase(c));
        }

        return unique.size();
    }
}