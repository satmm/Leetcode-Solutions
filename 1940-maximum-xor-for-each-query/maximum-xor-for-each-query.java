class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int k = (int) Math.pow(2, maximumBit) - 1;
        int [] prefix = new int [nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] ^ nums[i];
        }

        for(int i=0; i<nums.length; i++){
            nums[i] = k^prefix[nums.length - i - 1];
        }

        return nums;
    }
}