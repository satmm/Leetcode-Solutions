class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        
        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // Iterate through the array and check for the middle index
        for (int i = 0; i < nums.length; i++) {
            // Right sum can be derived from total sum and left sum
            int rightSum = totalSum - leftSum - nums[i];
            
            // Check if left sum equals right sum
            if (leftSum == rightSum) {
                return i;
            }
            
            // Update the left sum for the next iteration
            leftSum += nums[i];
        }
        
        // If no middle index is found, return -1
        return -1;
    }
}
