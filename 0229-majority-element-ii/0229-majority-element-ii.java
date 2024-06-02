class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                candidate1 = nums[i];
            } else if (count2 == 0) {
                count2 = 1;
                candidate2 = nums[i];
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0; 
        count2 = 0;
        for (int num : nums) {
            if(num==candidate1) count1++;
            else if(num==candidate2) count2++;
        }
        if(count1>nums.length/3) l.add(candidate1);
        if(count2>nums.length/3) l.add(candidate2);
        return l;
    }
}