class Solution {
    public long maxKelements(int[] nums, int k) {
       PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());
       for(int i:nums)
       pq.add(i);
       long score=0;
       for(int i=0;i<k;i++)
       {
        int ele=pq.poll();
        score+=ele;
        pq.add((int)Math.ceil((double)ele/3.0));
       }
       return score; 
    }
}