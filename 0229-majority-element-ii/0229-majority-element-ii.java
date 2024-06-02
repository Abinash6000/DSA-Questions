class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int count1 =  0, count2 = 0, candidate1 = 0, candidate2 = 1;

        for(int e : nums) {
            if(e == candidate1) count1++;
            else if(e == candidate2) count2++;
            else if(count1 == 0) {
                candidate1 = e;
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = e;
                count2 = 1;
            } else {
                count1--; count2--;
            }
        }

        count1 = 0; count2 = 0;
        for(int e : nums) {
            if(e == candidate1) count1++;
            else if(e == candidate2) count2++;
        }
        
        if(count1 > nums.length/3) ans.add(candidate1);
        if(count2 > nums.length/3) ans.add(candidate2);

        return ans;
    }
}