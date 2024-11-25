import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] dir = new int[][] {
                { 1, 3 },       // moves for index 0
                { 0, 2, 4 },    // moves for index 1
                { 1, 5 },       // moves for index 2
                { 0, 4 },       // moves for index 3
                { 1, 3, 5 },    // moves for index 4
                { 2, 4 }        // moves for index 5
        };
        
        String target = "123450"; // Target state
        StringBuilder sb = new StringBuilder();
        
        // Convert board to string representation
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        
        String start = sb.toString();
        
        // If the start state is already the target
        if (start.equals(target)) return 0;

        // Use a HashSet for visited states for O(1) lookup
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(start);
        visited.add(start);
        int moves = 0;

        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                
                if (curr.equals(target)) {
                    return moves; // Reached the solution
                }
                
                int zeroIndex = curr.indexOf('0'); // Find position of '0'

                // Swap '0' with each valid neighbor
                for (int newPos : dir[zeroIndex]) {
                    String nextState = swap(curr, zeroIndex, newPos);
                    
                    // Avoid revisiting states
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.add(nextState);
                    }
                }
            }
            moves++;
        }
        return -1; // Target not reachable
    }

    // Helper function to swap characters at two positions
    private String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}