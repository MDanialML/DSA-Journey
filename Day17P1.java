public class Day17P1{

    public static int findMax(int[] weights, int[] values, int W){
        int numItem = weights.length;
        int dp[][] = new int[numItem+1][W+1];

        //outer loop iterate over rows
        for(int i = 1; i <= numItem; i++){
            //inner loop fill max values for each weight capacity
            for(int j = 0; j <= W; j++){
                //exclude an item
                dp[i][j] = dp[i-1][j];
                //check, knapsack remaining capacity before adding another item
                if(weights[i-1] <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j- weights[i-1]] + values[i-1]);
                }
            }
        }
        return dp[numItem][W];
    }


    public static void main(String[] args){
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};

        int capacity = 7;

        int maxValue = findMax(weights, values, capacity);
        System.out.println("Max value: " + maxValue);
    }
}