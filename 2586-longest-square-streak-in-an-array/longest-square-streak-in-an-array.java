class Solution {
    public int longestSquareStreak(int[] nums) {
        HashMap<Long, Integer> hm = new HashMap<>();
        Arrays.sort(nums);
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            hm.put((long) nums[i], i);
        }

        for (int num : nums) {
            long num1 = num;
            int count = 0;

            while (hm.containsKey(num1 * num1)) {
                num1 = num1 * num1;
                count++;
            }

            if (count > max) {
                max = count;
            }
        }

        return max == 0 ? -1 : max + 1;     
    }
}