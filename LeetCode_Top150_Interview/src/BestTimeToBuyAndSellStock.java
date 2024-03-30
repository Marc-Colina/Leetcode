//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//
//
//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(STR."Max Profit is : \{maxProfit(prices)}");
    }

    public static int maxProfit(int[] prices) {
        //We initialize the values of cheapestPrice and mostExpensivePrice to -1 since we are expecting all prices to be either 0 or greater.
        int cheapestPrice = -1;
        int mostExpensivePrice = -1;

        //We initialize maxProfit to 0 so that if no maxProfit is obtained, the return defaults to 0.
        int maxProfit = 0;

        for (int price : prices) {
            //First we have to assign the first price in the array and assume it's the cheapest. We have to add this
            //because price < cheapestPrice will never be true since we initialized our cheapestPrice to -1.
            if (cheapestPrice == -1)
                cheapestPrice = price;
            //Once we have our cheapestPrice, we look out for other prices that are cheaper than the current price.
            //In our current input {3,2,6,5,0,3}, on the second iteration, 2 < 3 (since our cheapestPrice is 3 thanks to the first
            //if statement above) will be true. So we then assign our new cheapestPrice to be 2. On top of that, we also need to
            //reset the value of mostExpensivePrice to -1 because this would mean that the previous mostExpensive price won't matter
            //anymore. This is because when we encounter the cheapest price, we "buy" that stock at that price and we can only sell
            //it based on the upcoming prices in the coming days (which is represented by the prices in the upcoming indexes) deeming
            //the highest prices before, irrelevant.
            else if (price < cheapestPrice) {
                cheapestPrice = price;
                mostExpensivePrice = -1;
            }
            //If the current price is not less than the current cheapestPrice, this condition will perform. And if the price
            //is greater than the current mostExpensivePrice, we then assign the price to mostExpensivePrice. When this happens,
            //we are sure that at this state, we currently have a cheapest price and a mostExpensivePrice so we now have to subtract
            //to see our profit. It is important to do this because in the problem we are being asked to track at what point
            // in time could we get the maximum profits. Meaning, we have to keep track of the possible times where we bought the stock
            // and then sold it and store it in the maxProfit variable. Everytime we buy and sell the stock, we compare the profit at that
            // point in time to our maxProfit. If it's greater, we update the maxProfit. It is important to note that
            // we are not only tracking the profit on the last days but we are tracking the maximum profit in all of the days at different
            // points in time.
            else if (price > mostExpensivePrice) {
                mostExpensivePrice = price;
                //The first time this inner if executes, this will mostly return true because
                //the current maxProfit is set to 0 and if there is profit being made it will always be greater than 0 hence we assign
                //the new profit to maxProfit. As we traverse through the array, we may encounter different points in time where
                //there is another opportunity to buy and sell stock (this opportunity comes when there is a price cheaper than the
                //current cheapestPrice and there is a price greater than the current mostExpensivePrice. When that happens, it will first
                //check if the current profit gained from that most recent buy and sell is greater than the maxProfit we have gained
                //so far. If yes, it will update maxProfit.

                //In our given, the first buy and sell happens when the cheapest price is 2 and the mostExpensivePrice is 6. This will give
                //us a maxProfit of 4. Another buy and sell happens when we encounter 0 on the 4th index because 0 is currently less than
                //the cheapestPrice which is 2. When this happens, the mostExpensivePrice is set back to -1 and on the next iteration,
                // 3 < 0 evaluates to false and then the else if 3 > -1 evaluates to true. We then set our mostExpensivePrice to 3 and
                // since mostExpensivePrice - cheapestPrice evaluates to 3-0 which is 3, the maxProfit we first obtained in the earlier
                //iterations which was 4 is greater, hence this if evaluates to false and maxProfit will remain 4.
                if (maxProfit < mostExpensivePrice - cheapestPrice)
                    maxProfit = mostExpensivePrice - cheapestPrice;
            }
        }
        //The Math.max method will just return the greater value. If maxProfit is greater than 0, it will return it. Else,
        //it will return 0. If equal, it will return 0, as it should, meaning there was no maxProfit in buying and selling the stock.
        return Math.max(maxProfit, 0);
    }
}
