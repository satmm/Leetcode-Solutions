class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for (int i=0;i<= nums.length;i++){
            int complements = target - nums[i];
            if(map.containsKey(complements)){
                return new int[]{map.get(complements)+1,i+1};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}