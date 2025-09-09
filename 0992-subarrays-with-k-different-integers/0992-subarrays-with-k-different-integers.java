class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subsWithK(nums, k) - subsWithK(nums, k-1);
    }

    private int subsWithK(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int st = 0, ed = 0;

        while(ed < nums.length) {
            hm.put(nums[ed], hm.getOrDefault(nums[ed], 0)+1);

            while(hm.size() > k) {
                hm.put(nums[st], hm.get(nums[st]) -1);
                if(hm.get(nums[st]) == 0)
                    hm.remove(nums[st]);

                
                st++;
            }

            res += ed-st+1;
            ed++;
        }

        return res;
    }
}