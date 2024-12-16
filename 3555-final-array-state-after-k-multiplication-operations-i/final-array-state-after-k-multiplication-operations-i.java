class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> q = new PriorityQueue<>(10, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        int l = nums.length;
        for(int i = 0; i < l; i++) {
            q.add(new int[]{nums[i], i});
        }
        while(k > 0) {
            int c[] = q.poll();
            c[0] *= multiplier;
            q.add(c);
            k--;
        }
        int ans[] = new int[l];
        while(!q.isEmpty()) {
            int c[] = q.poll();
            ans[c[1]] = c[0];
        }
        return ans;
    }
}