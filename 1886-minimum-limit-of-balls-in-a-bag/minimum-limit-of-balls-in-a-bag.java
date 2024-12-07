class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // Initialize the search boundaries
        int left = 1;
        int right = 0;

        // Find the maximum bag size from the input nums
        for (int num : nums) {
            right = Math.max(right, num);
        }

        // Perform the binary search
        while (left < right) {
            // Find the middle value to test
            int mid = (left + right) >>> 1;

            // Calculate the total number of operations required using 'mid' as a boundary
            long count = 0;
            for (int num : nums) {
                // For each bag, calculate the number of operations needed
                count += (num - 1) / mid;
            }

            // If the number of operations is within the allowed maxOperations,
            // we should try a smaller max bag size hence update the right boundary
            if (count <= maxOperations) {
                right = mid;
            } else {
                // Otherwise, we need a larger bag size to reduce the operation count
                // so update the left boundary
                left = mid + 1;
            }
        }

        // When the loop exits, 'left' is the minimum possible largest bag size
        return left;
    }
}