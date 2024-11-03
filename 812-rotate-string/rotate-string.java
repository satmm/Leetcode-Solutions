class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder str = new StringBuilder(s);
        if(goal.length() != s.length()){
            return false;
        }
        for(int i = 0; i<s.length(); i++){
            if(str.toString().equals(goal)){
                return true;
            }
            else{
                str.append(str.charAt(0));
                str.deleteCharAt(0);
            }
        }
        return false;
    }
}