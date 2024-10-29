class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] path = new boolean[m][n];

        for (int i = 0; i < m; i++)
            path[i][0] = true;

        for (int c = 1; c < n; c++){
            boolean flag = false;

            for (int r = 0; r < m; r++){
                int val = grid[r][c];

                if ((r-1 >= 0 && path[r-1][c-1] && val > grid[r - 1][c-1]) ||
                    (path[r][c-1] && val > grid[r][c-1]) ||
                    (r+1 < m && path[r+1][c-1] && val > grid[r + 1][c-1])){
                        flag = true;
                        path[r][c] = true;
                    }
            }

            if (!flag)
                return (c - 1);
        }

        return n - 1;
    }
}
