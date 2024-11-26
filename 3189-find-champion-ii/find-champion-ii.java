class Solution {
    public int findChampion(int n, int[][] edges) {
        int inDegree[] = new int[n];
        int edge = -1;
        for(int i=0; i<edges.length; i++){
            inDegree[edges[i][1]]++;
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0) {
                edge = i;
                count++;
            }
        }
        return count == 1?edge:-1;
    }
}