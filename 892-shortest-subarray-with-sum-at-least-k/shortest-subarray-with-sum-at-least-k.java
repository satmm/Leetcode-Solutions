class Solution {

    private static class Node {
        public long min;
        public int from;
        public int to;
        public Node left;
        public Node right;

        public Node(long[] arr, int from, int to){
            this.from = from;
            this.to = to;
            if(from == to) {
                min = arr[from];
                return;
            }

            int mid = (from + to) / 2;
            left = new Node(arr, from, mid);
            right = new Node(arr, mid+1, to);
            min = Math.min(left.min, right.min);
        }

        public long getMin(int l, int r) {
            if(l > to || r < from) return Long.MAX_VALUE;
            if(from >= l && to <= r) return min;
            return Math.min(left.getMin(l, r), right.getMin(l, r));
        }
    }
    
    public int shortestSubarray(int[] nums, int k) {
        long[] qsum = new long[nums.length];
        qsum[0] = nums[0];
        for(int i = 1;i < nums.length;i++)
            qsum[i] = qsum[i-1] + nums[i];
        Node root = new Node(qsum, 0, qsum.length-1);

        int ans = -1;
        for(int i = 0;i < nums.length;i++) {
            int l = 0, r = i, target = -1;
            while(l <= r) {
                int mid = (l + r) / 2;
                if(qsum[i] - root.getMin(mid, i) >= k) {
                    target = mid;
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }

            if(qsum[i] >= k && (ans == -1 || i+1 < ans)) ans = i+1;
            if(target >= 0 && (ans == -1 || i-target < ans)) ans = i-target;
        }
        return ans;
    }
}