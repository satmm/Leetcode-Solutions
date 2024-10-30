class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        List<Integer> lis = new ArrayList<>();
        int[] incLis = new int[n];
        int[] decLis = new int[n];

        for(int i=0;i<n;i++){
            int num=nums[i];
            if(lis.size()==0 || num>lis.get(lis.size()-1)){
                lis.add(num);
            }else {
                lis.set(getCeilPos(lis, num), num);
            }
            incLis[i]=lis.size();
        }

        lis.clear();
        int max=0;

        for(int i=n-1;i>=0;i--){
            int num=nums[i];
            if(lis.size()==0 || num>lis.get(lis.size()-1)){
                lis.add(num);
            }else {
                lis.set(getCeilPos(lis, num), num);
            }
            decLis[i]=lis.size();
            if(decLis[i]>1 && incLis[i]>1){
                max=Math.max(max, decLis[i]+incLis[i]-1);
            }
        }

        return n-max;
    }

    int getCeilPos(List<Integer> lis, int num){
        int l=0, r=lis.size()-1;
        int res=0;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(lis.get(mid)>=num){
                r=mid-1;
                res=mid;
            }
            else {
                l=mid+1;
            }
        }

        return res;
    }
}

