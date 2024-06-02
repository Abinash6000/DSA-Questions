class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 1) {
            ans.add(nums[0]);
            return ans;
        }

        int count1 =  0, count2 = 0;
        int candidate1 = -1, candidate2 = -2;

        for(int e : nums) {
            if(count1 <= 0) {
                candidate1 = e;
                count1++;
            } else if(count2 <= 0) {
                candidate2 = e;
                count2++;
            }

            if(e == candidate1) count1++;
            else if(e == candidate2) count2++;
            else {
                count1--; count2--;
            }
        }

        int c1 = 0, c2 = 0;
        for(int e : nums) {
            if(e == candidate1) c1++;
            else if(e == candidate2) c2++;
        }
        
        if(c1 > nums.length/3) ans.add(candidate1);
        if(c2 > nums.length/3) ans.add(candidate2);

        return ans;
    }
}