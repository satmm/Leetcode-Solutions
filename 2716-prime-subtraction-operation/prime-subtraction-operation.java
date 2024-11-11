class Solution {
    public boolean primeSubOperation(int[] nums) {
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]==nums[i-1] && nums[i-1]==1){
                return false;
            }
            if(nums[i]<=nums[i-1]){
                if(nums[i]==0){
                    return false;
                }
                int diff = nums[i-1]-nums[i];
                int prime = givePrime(diff+1,nums[i-1]);
                nums[i-1] -= prime;
                if(nums[i-1]==0){
                    return false;
                }
            }
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                return false;
            }
        }
        return true;
    }
    public static int givePrime(int start,int end){
        if(start==1){
            start = 2;
        }
        for(int i=start;i<=end;i++){
            if(prime(i)){
                return i;
            }
        }
        return 2;
    }
    public static boolean prime(int temp){
        for(int i=2;i<temp;i++){
            if(temp%i==0){
                return false;
            }
        }
        return true;
    }
}