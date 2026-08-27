import java.util.Arrays;

public class FinalPrice {

    public int[] finalPrices(int[] prices) {

        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {

                // Find the first price <= current price
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return prices;
    }

    public static void main(String[] args) {

        FinalPrice obj = new FinalPrice();

        int[] prices = {8, 4, 6, 2, 3};

        System.out.println(Arrays.toString(obj.finalPrices(prices)));
    }
}
