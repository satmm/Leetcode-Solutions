class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;        
        int[][] res = new int[m][n];  
        for(int[] row : res) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        res[0][0] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0});
        int[][] dir = {{0, 1}, {0, -1}, {1, 0},{-1, 0}};
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int obstCnt = cur[0];
            int i = cur[1];
            int j = cur[2];
            
            for(int[] d : dir) {
                int x = i + d[0];
                int y = j + d[1];
                if(x >= 0 && x < m && y >= 0 && y < n) {
                   int wt = (grid[x][y] == 1) ? 1 : 0;
                    if(obstCnt + wt < res[x][y]) {
                        res[x][y] = obstCnt + wt;
                        pq.offer(new int[] {obstCnt + wt, x, y});
                    }
                }
            }
        }
        return res[m - 1][n - 1];
    }
}