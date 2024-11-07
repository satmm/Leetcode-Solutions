
class Solution {
    public int largestCombination(int[] candidates) {
        if (candidates.length == 0) {
            return 0;
        }
        int[] bitscount = new int[24];
        for (int number : candidates) {
            String binary = Integer.toBinaryString(number);
            int idx = bitscount.length - 1;
            for (int i = binary.length() - 1; i >= 0; i--, idx--) {
                if (binary.charAt(i) == '1') {
                    bitscount[idx]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < bitscount.length; i++) {
            max = Math.max(max, bitscount[i]);
        }
        return max;
    }
}