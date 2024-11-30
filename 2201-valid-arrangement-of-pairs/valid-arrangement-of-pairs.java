class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        
        for(int[] edge : pairs) {
            int u = edge[0];
            int v = edge[1]; 
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }
        int start = pairs[0][0];
        for(int node : adj.keySet()) {
            if(outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                start = node;
                break;
            }
        }
        
        List<Integer> path = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(start);
        while(!stk.isEmpty()) {
            int cur = stk.peek();
            if(adj.containsKey(cur) && !adj.get(cur).isEmpty()) {
                int nbr = adj.get(cur).remove(adj.get(cur).size() - 1);
                stk.push(nbr);
            } else {
                path.add(cur);
                stk.pop();
            }
        }
        
        Collections.reverse(path);
        int[][] res = new int[path.size() - 1][2];
        for(int i = 0; i < path.size() - 1; i++) {
           res[i][0] = path.get(i);
            res[i][1] = path.get(i + 1);
        }
       return res;
    }
}