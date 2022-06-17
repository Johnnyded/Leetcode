/*
 * This problem will consist of iterating throught the array once for to achieve 
 *  O(n) time. While iterating through it we will be keeping track of the lowest 
 *   price to buy and updating it. At the same time, we will keep track of the price/index
 *    where we can sell the stock for the maximum PROFIT to ensure we don't sell before
 *     we buy
 * The main trick here is making sure that the selling price comes after the buying 
 *  price
 */
class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, profit=0;
        for (int i=0; i < prices.length; i++){
            //Updating lowest buying price
            buy = Math.min(prices[i], buy);
            //Updating highest profit with new/old buying price
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
        
    }
}