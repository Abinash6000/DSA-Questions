class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        for (int i = 0; i + k <= n; i++) {
            HashMap<Integer,Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }
            
            // convert freq map to list of pairs <freq, value>
            List<int[]> list = new ArrayList<>();
            for (var e : freq.entrySet()) {
                list.add(new int[]{e.getValue(), e.getKey()});
            }
            
            // sort: freq desc, then value desc
            list.sort((a,b) -> {
                if (b[0] != a[0]) return b[0] - a[0];
                return b[1] - a[1];
            });
            
            int sum = 0;
            int used = 0;
            for (int[] p: list) {
                if (used == x) break;
                sum += p[0] * p[1];
                used++;
            }
            ans[i] = sum;
        }
        
        return ans;
    }
}
