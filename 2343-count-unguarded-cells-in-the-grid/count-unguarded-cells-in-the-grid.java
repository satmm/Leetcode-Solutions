class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // ArrayList<String> wall = new ArrayList<>();
        // ArrayList<String> guard = new ArrayList<>();
        // char[][] guard=new char[][n];
        // char[][] seen=new char[m][n];
        char[][] matrix=new char[m][n];

        for (int[] g : walls) {
            matrix[g[0]][g[1]]='w';

            // wall.add(("" + g[0] + "," + g[1]));

        }
        for (int[] g : guards) {
            matrix[g[0]][g[1]]='g';
            // guard.add(("" + g[0] + "," + g[1]));

        }
        // ArrayList<String> seen = new ArrayList<>();
        for (int i = 0; i < guards.length; i++) {

            int a = guards[i][0];
            int b = guards[i][1];
            // Checking left side of guard;
            for (int l = b - 1; l >= 0; l--) {
                if (matrix[a][l]=='g' || matrix[a][l]=='w') {
                    break;
                }
                matrix[a][l]='v';
                    // System.out.println(""+a+","+l);
                
                ;

            }
            // walll=false;

            // Checking right side of guard;
            for (int r = b + 1; r < n; r++) {
                if (matrix[a][r]=='g'|| matrix[a][r]=='w') {
                    break;
                }
                matrix[a][r]='v' ;

            }
            // System.out.println(""+a+r);

            // walll=false;
            // Checking up side of guard;
            for (int u = a - 1; u >= 0; u--) {
                if (matrix[u][b]=='g' || matrix[u][b]=='w') {
                    break;
                }
                matrix[u][b]='v';
                // System.out.println(""+u+b);
            }
            // Checking down side of guard;
            // walll=false;
            for (int d = a + 1; d < m; d++) {
                if (matrix[d][b]=='g'|| matrix[d][b]=='w') {
                    break;
                }
                matrix[d][b]='v';
            }
        }
        // System.out.println(""+d+b);
        // System.out.println(""+d+b);
        int notvisible=0;
        for(int q=0;q<m;q++){
            for(int e=0;e<n;e++){
                if(matrix[q][e]=='v' ||matrix[q][e]=='w' || matrix[q][e]=='g'){
                    continue;
                }
                    notvisible++;
            }
        }
        return notvisible;
    }
}