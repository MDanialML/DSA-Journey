public class Day33P5{

    public static int minimumCoins(int[] coins, int amount){
        //create a table for bottom up calculation
        int[] dp = new int[amount+1];
        dp[0] = 0;
        //fill remaining places with infinity :use amount+1 to avoid integer over flow
        for(int i =1; i<= amount; i++){
            dp[i] = amount+1;
        }

        //building solution from 1 to amount
        for(int i =1; i <= amount; i++){
            //filling coins count for each coin
            for(int coin: coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        //final requirement
        return dp[amount] == amount+1?-1:dp[amount];
    }



    //driver function
    public static void main(String[] args){
        int[] coins = {1, 2, 5};
        int amount = 11;
        
        int numberOfCoins = minimumCoins(coins, amount);
        System.out.println("Mininmum Coins required:    " + numberOfCoins);
    }
}