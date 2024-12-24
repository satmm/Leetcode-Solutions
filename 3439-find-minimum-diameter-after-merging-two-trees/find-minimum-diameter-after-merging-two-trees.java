class Solution {
    int ans = 0;
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = getDiameter(edges1), d2 = getDiameter(edges2);
        return Math.max(ans, d1 + d2 + 1);
    }
    int getDiameter(int[][] edges) {
        int n = edges.length + 1;
        int inDegree[] = new int[n];
        List<Integer> adj[] = new ArrayList[n];
        for(int e[] : edges) {
            inDegree[e[0]]++;
            inDegree[e[1]]++;
            if(adj[e[0]] == null) {
                adj[e[0]] = new ArrayList<>();
            }
            adj[e[0]].add(e[1]);
            if(adj[e[1]] == null) {
                adj[e[1]] = new ArrayList<>();
            }
            adj[e[1]].add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 1) {
                q.add(i);
            }
        }
        int length = 0;
        while(q.size() > 1) {
            Queue<Integer> q1 = new LinkedList<>();
            while(!q.isEmpty()){
                int x = q.remove();
                for(int y : adj[x]) {
                    inDegree[y]--;
                    if(inDegree[y] == 1) {
                        q1.add(y);
                    }
                }   
            }
            length++;
            q = q1;
        }
        ans = Math.max(ans, q.size() == 1 ? 2 * length : 2 * length - 1);
        return length;
    }
}