class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        
        // If the lengths are different or the non-underscore characters don't match
        if (start.replace("_", "").equals(target.replace("_", "")) == false) {
            return false;
        }
        
        int lp = 0, rp = 0;
        
        while (lp < n && rp < n) {
            // Skip over underscores in both start and target
            while (lp < n && start.charAt(lp) == '_') {
                lp++;
            }
            while (rp < n && target.charAt(rp) == '_') {
                rp++;
            }
            
            // If we reach the end of both strings, they are equal
            if (lp == n && rp == n) {
                break;
            }

            // If we reach the end of one string but not the other, return false
            if (lp == n || rp == n) {
                return false;
            }

            // Compare the characters at lp and rp
            if (start.charAt(lp) != target.charAt(rp)) {
                return false;
            }

            // Check if movement is valid for 'L' and 'R' characters
            if (start.charAt(lp) == 'L' && rp > lp) {
                return false;
            }
            if (start.charAt(lp) == 'R' && rp < lp) {
                return false;
            }
            
            // Move both pointers forward
            lp++;
            rp++;
        }
        
        return true;
    }
}
