class Solution {
    public int maxAscendingSum(int[] nums) {
        int current = nums[0], ans=nums[0];
        for (int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                current += nums[i];
            }else{
                current = nums[i];
            }

            ans= Math.max(ans,current);
           
            

        }
        return ans;
        
    }
}