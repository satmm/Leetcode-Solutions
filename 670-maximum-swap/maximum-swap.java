class Solution {
    public int maximumSwap(int num) {
        char[] numStr = Integer.toString(num).toCharArray();
        int n = numStr.length;

        int maxIdx = n - 1;
        int leftIdx = -1, rightIdx = -1;

        for (int i = n - 2; i >= 0; --i) {
            if (numStr[i] > numStr[maxIdx]) {
                maxIdx = i;
            } else if (numStr[i] < numStr[maxIdx]) {
                leftIdx = i;
                rightIdx = maxIdx;
            }
        }

        if (leftIdx == -1) return num;
        char temp = numStr[leftIdx];
        numStr[leftIdx] = numStr[rightIdx];
        numStr[rightIdx] = temp;

        return Integer.parseInt(new String(numStr));
    }
}