import java.util.Arrays;

public class Day14P1{


    //Naive Recurrsion
    public static int recursiveWays(int n){
        //edge case 
        if(n == 0) throw new RuntimeException("Provide a Valid Input!");
        //base case 
        if(n == 1) return 1;
        if(n ==2) return 2;

        return  recursiveWays(n-1) + recursiveWays(n-2);
    }

    //Memoization
    public static int memoizationWays(int n, int[] cache){

        //edge case 
        if(n == 0) throw new RuntimeException("Provide a Valid Input!");
        //base case 
        if(n == 1) return cache[n]= n;
        if(n ==2) return cache[n] = n;

        if(cache[n] != -1) return cache[n];
        cache[n] = memoizationWays(n-1, cache) + memoizationWays(n-2, cache);
        return cache[n];
    }

    //tabulation
    public static int tabulationWays(int n){
        //edge case 
        if(n == 0) throw new RuntimeException("Provide a Valid Input!");

        int[] dp = new int[n+1];
         dp[1] = 1;
         dp[2] = 2;
         int i = 3;

        while(i < dp.length)
        {
           dp[i] = dp[i-1] + dp[i-2];
           i++;
        }
        return dp[n];
        
    }



    //driver function
    public static void main(String[] args){
        int number = 6;

        //naive recurrsion
        System.out.println(recursiveWays(number));

        //memoization
        int[] memo = new int[number+1];
        Arrays.fill(memo, -1);
        System.out.println(memoizationWays(number, memo));

        //tabulation
        System.out.println(tabulationWays(number));





    }
}