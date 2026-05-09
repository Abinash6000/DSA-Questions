class Solution {

    public int[] maxValue(int[] nums) {

        int n = nums.length;
        int result[] = new int[n];
        int preMax[] = new int[n];

        preMax[0] = nums[0];
        for(int i=1; i<n; i++){
            preMax[i] = Math.max(preMax[i-1],nums[i]);
        }

        int suffMin = Integer.MAX_VALUE;

        for(int i=n-1; i>=0; i--){
            
            if(preMax[i] > suffMin){
                result[i] = result[i+1];
            }else{
                result[i] = preMax[i];
            }

            suffMin = Math.min(suffMin,nums[i]);
        }
        return result;
    }
}