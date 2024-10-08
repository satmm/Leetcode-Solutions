class Solution {
    public int minSwaps(String s) {
        // Initialize a variable to keep track of unmatched opening brackets
        int stackSize = 0;

        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                // If we encounter an opening bracket, increment the stack size
                stackSize++;
            } else {
                // If we encounter a closing bracket
                if (stackSize > 0) {
                    // If there's a matching opening bracket (stackSize > 0),
                    // decrement the stack size
                    stackSize--;
                }
                
            }
        }

        // Calculate the minimum number of swaps needed
        // We need to swap half of the remaining unmatched brackets
        // Use integer division and add 1 to round up for odd numbers
        return (stackSize + 1) / 2;
    }
}