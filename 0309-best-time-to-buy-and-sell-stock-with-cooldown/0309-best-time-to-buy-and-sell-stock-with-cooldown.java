class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int coolDown = 0;
        for(int price : prices){
            int prevbuy = buy;
            int prevsell = sell;
            int prevcoolDown = coolDown;
            buy = Math.max(prevbuy , coolDown-price);
            sell = prevbuy + price;
            coolDown = Math.max(prevcoolDown, prevsell);
        }
        return Math.max(sell, coolDown);
    }
}