class Solution {
    private static boolean canDevide(int num,int[] q,int n){
        int devide=0;
        for(int quantity : q){
           devide += (quantity + num - 1) / num;
        }
        if(devide<=n){
            return true;
        }
        return false;
    }
    private static int findMin(int max,int[]quantities,int n){
        int high = max;
        int low = 1;
        while(low<high){
            int mid = low +(high-low)/2;
            if(canDevide(mid,quantities,n)){
                high = mid;
            }
            else{
                low = mid+1;
            }

        }
        return low;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int max = Integer.MIN_VALUE;
        int k = quantities.length;
        for(int i =0;i<k;i++){
           max= Math.max(quantities[i],max);
        }
        return findMin(max,quantities,n);
    }
}