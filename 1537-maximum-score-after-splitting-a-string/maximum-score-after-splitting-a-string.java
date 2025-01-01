class Solution {
    public int maxScore(String s) {
        int maxScore = 0;
        int zerosToLeft = 0;
        int onesToRight = countOnes(s);

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zerosToLeft++;
            } else {
                onesToRight--;
            }
            maxScore = Math.max(maxScore, zerosToLeft + onesToRight);
        }

        return maxScore;
    }
     private int countOnes(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
}