class Solution {
    public  int minChanges(String s) {
         int ans=0;
         char ch,ch1;
         for(int i=0;i<s.length();i=i+2)
         {  ch=s.charAt(i);
             ch1=s.charAt(i+1);
             if(ch!=ch1)
             {
                 ans++;
             }
         }
         return ans;
    }
}