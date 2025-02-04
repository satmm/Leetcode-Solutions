class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> search = new HashSet<>();
        for(int num : nums)
        {
            if(search.contains(num)){
                return true;
            }

           search.add(num);
        
            
        }
       
        return false;
        
    }
}