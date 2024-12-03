class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        int n = s.length() , spacePointer = 0;

        for(int i = 0 ; i < n ; i++){
            if(spacePointer < spaces.length && i == spaces[spacePointer]){
                ans.append(' ');
                ans.append(s.charAt(i));
                spacePointer++;
            }else{
                ans.append(s.charAt(i));
            }
        }
        
        return ans.toString();
    }
}