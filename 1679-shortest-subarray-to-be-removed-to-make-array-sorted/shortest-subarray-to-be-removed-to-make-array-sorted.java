class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        List<Integer> prefix = new ArrayList<>();
        List<Integer> suffix = new ArrayList<>();

        prefix.add(arr[0]);
        int left=1, right=n-2;

        while(left<n && arr[left]>=prefix.get(prefix.size()-1)){
            prefix.add(arr[left++]);
        }
        if(left<n-1) suffix.add(arr[n-1]);
        
        while(right>=0 && right>=left && arr[right]<=suffix.get(suffix.size()-1)){
            suffix.add(arr[right--]);
        }

        Collections.reverse(suffix);

        int p=0, s=0;
        int res=n-Math.max(prefix.size(), suffix.size());

        while(p<prefix.size() && s<suffix.size()){
            if(prefix.get(p)<=suffix.get(s)){
                res=Math.min(res, n-(p+(suffix.size()-s)+1));
                p++;
            }else{
                s++;
            }
        }
    
        return res;
    }
}