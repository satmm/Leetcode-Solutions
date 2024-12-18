class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<prices.length; i++){
            while(!s.isEmpty() && prices[s.peek()]>=prices[i]){
                int index = s.pop();
                prices[index] = prices[index] - prices[i];
            }
            s.add(i);
        }
        return prices;
    }
}