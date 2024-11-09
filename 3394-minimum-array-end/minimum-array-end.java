class Solution {
    public long minEnd(int n, int x) {
        long y = x;
        long mask ;
        n--;
        for(mask = 1; n>0 ; mask <<= 1){
            if((x & mask) == 0){
                y |= (n & 1)*mask;
                n >>= 1;
            }
        }
        return y;
    }
}
