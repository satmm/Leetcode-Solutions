class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        List<Integer> list=new ArrayList<>();
        int[] sorted=queries.clone();
        Arrays.sort(sorted);
        Arrays.sort(items,(a,b)->
        {
            if(a[0]!=b[0])
            {
                return Integer.compare(a[0],b[0]);
            }
            else
            {
                return Integer.compare(a[1],b[1]);
            }
        });
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int maxbeauty=0;
        for(int[] item:items)
        {
           maxbeauty=Math.max(maxbeauty,item[1]);
           map.put(item[0],maxbeauty);
        }
        for(int i=0;i<queries.length;i++)
        {
            if(map.floorKey(queries[i])!=null)
            {
                int key=map.floorKey(queries[i]);
                queries[i]=map.get(key);
            }
            else
            {
                queries[i]=0;
            }
        }
        return queries;
    }
}