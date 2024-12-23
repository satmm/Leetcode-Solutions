/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        dfs(root, levelOrderTraversal, 0);
        int result = 0;
        for(List<Integer> level: levelOrderTraversal){
            for(int val: level){
                System.out.print(val + " ");
            }
            System.out.println();
            result += numOperations(level);
        }
        return result;
    }
    
    public void dfs(TreeNode root, List<List<Integer>> levelOrderTraversal, int depth){
        if(root==null){
            return;
        }
        if(levelOrderTraversal.size()<depth+1){
            levelOrderTraversal.add(new ArrayList<>());
        }
        levelOrderTraversal.get(depth).add(root.val);
        dfs(root.left, levelOrderTraversal, depth+1);
        dfs(root.right, levelOrderTraversal, depth+1);
    }
    
    
    
    //given a list I need to find the minimum number of operations to make list strictly increasing.
    public int numOperations(List<Integer> list){
        int swaps = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<list.size(); i++){
            map.put(list.get(i), i);
        }
        List<Integer> cloned_list = new ArrayList<Integer>(list);
        Collections.sort(cloned_list);
        for(int i=0; i<list.size(); i++){
            if(list.get(i) != cloned_list.get(i)){
                swaps++;
                int j = map.get(cloned_list.get(i));
                Collections.swap(list, i, j);
                map.put(list.get(i), i);
                map.put(list.get(j), j);
            }
        }
        return swaps;
    }
}