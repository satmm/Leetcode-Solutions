class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // Step 1: Find the maximum number in the array for the frequency array size
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        // Step 2: Initialize helper data structures and variables
        int[] counts = new int[maxNum + 1]; // Frequency count of numbers
        int dupCount = 0;                  // Count of duplicates in the current window
        long totalSum = 0;                 // Maximum sum of valid subarrays
        long curSum = 0;                   // Current window sum
        
        // Step 3: Process the first k elements to initialize the sliding window
        for (int i = 0; i < k; i++) {
            if (counts[nums[i]] >= 1) { // Duplicate detected
                dupCount++;
            }
            counts[nums[i]]++;         // Update frequency count
            curSum += nums[i];         // Add to current sum
        }
        if (dupCount == 0) {            // No duplicates, update totalSum
            totalSum = curSum;
        }
        
        // Step 4: Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            // Add the next element to the window
            if (counts[nums[i]] >= 1) {
                dupCount++;
            }
            counts[nums[i]]++;
            curSum += nums[i];
            
            // Remove the oldest element from the window
            if (counts[nums[i - k]] > 1) {
                dupCount--;
            }
            counts[nums[i - k]]--;
            curSum -= nums[i - k];
            
            // Update totalSum if the window has no duplicates
            if (dupCount == 0) {
                totalSum = Math.max(totalSum, curSum);
            }
        }
        
        // Step 5: Return the result
        return totalSum;
    }
}