class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int prev = 0; // To track the starting index of the next substring
        
        for (int i = 0; i < spaces.length; i++) {
            // Extract substring between `prev` and `spaces[i]`
            sb.append(s.substring(prev, spaces[i]));
            sb.append(" "); // Add a space
            prev = spaces[i]; // Update `prev` to current space index
        }
        sb.append(s.substring(prev));
        
        
         return sb.toString();
        
    }
    
   
    
    
}