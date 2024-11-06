class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[i] && Integer.bitCount(nums[j]) != Integer.bitCount(nums[i])){
                    return false;
                }
            }
        }
        return true;
    }
}