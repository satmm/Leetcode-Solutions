class Solution {
    public int maximumLength(String s) {
        // Arrays to track maximum runs and their counts for each character
        int[] f1 = new int[26];  // Longest run length for each character
        int[] f2 = new int[26];  // Count of occurrences of that run length
        
        int curr = 1;  // Current run length
        int ans = -1;  // Final result (-1 indicates no valid substring initially)
        char[] a = s.toCharArray();  // Convert input string to character array
        f2[(int)(a[0] - 'a')] = 1;  // Initialize counts for the first character
        f1[(int)(a[0] - 'a')] = 1;
        int n = s.length();
        
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                curr++;  // Increment run length if current character matches previous
            } else {
                curr = 1;  // Reset run length otherwise
            }
            int g = (int)(a[i] - 'a');  // Map character to index (0 to 25 for 'a' to 'z')
            
            if (curr > f1[g]) {  // Case 1: Current run exceeds maximum so far
                f1[g] = curr;
                ans = Math.max(ans, curr - 2);  // Maximum with one character removed
                if (f2[g] >= 2) ans = Math.max(curr - 1, ans);  // Extend if valid
                f2[g] = 1;  // Reset occurrences to 1
            } else if (curr == f1[g] - 1) {  // Case 2: Current run matches maximum minus 1
                ans = Math.max(curr, ans);
                ans = Math.max(ans, curr - 2);
            } else if (curr == f1[g]) {  // Case 3: Current run matches maximum
                f2[g]++;
                if (f2[g] >= 3) ans = Math.max(curr, ans);  // Extend if sufficient occurrences
            }
        }
        return ans <= 0 ? -1 : ans;  // Return -1 if no valid substring is found
    }
}