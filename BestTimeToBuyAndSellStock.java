public class BestTimeToBuyAndSellStock {

    public static int solution(int[] prices) {

        int minPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            profit = Math.max(profit, currentPrice - minPrice);
            minPrice = Math.min(minPrice, currentPrice);
        }

        return profit;

    }
    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(solution(prices));
    }
}
