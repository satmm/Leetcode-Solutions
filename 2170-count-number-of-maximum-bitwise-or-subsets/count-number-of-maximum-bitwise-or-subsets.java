import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Calculate the maximum possible OR of all elements
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Use memoization to optimize counting subsets with max OR
        Map<Integer, Integer> memo = new HashMap<>();
        return countSubsets(nums, 0, 0, maxOr, memo);
    }

    private int countSubsets(int[] nums, int index, int currentOr, int maxOr, Map<Integer, Integer> memo) {
        // If we reach the end of the array, check if the current OR matches maxOr
        if (index == nums.length) {
            return (currentOr == maxOr) ? 1 : 0;
        }

        // Memoization check to avoid redundant calculations
        int memoKey = (index << 20) | currentOr;  // Unique key based on index and current OR value
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        // Option 1: Exclude current element
        int exclude = countSubsets(nums, index + 1, currentOr, maxOr, memo);

        // Option 2: Include current element and update the OR
        int include = countSubsets(nums, index + 1, currentOr | nums[index], maxOr, memo);

        // Memoize the result
        int result = exclude + include;
        memo.put(memoKey, result);
        
        return result;
    }
}