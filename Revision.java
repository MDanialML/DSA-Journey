import java.util.Arrays;
public class Revision{

    public static int ways(int steps, int[] memo){
        if(steps == 1) return memo[steps] = steps;
        if(steps == 2) return memo[steps] = steps;

        if(memo[steps] != -1){
            return memo[steps];
        }
        memo[steps] = ways(steps-2, memo) + ways(steps-1, memo);
        return memo[steps];
    }

    public static int findWays(int steps){
        if(steps <= 0){
            throw new IllegalArgumentException("Invalid input");
        }
        int[] memo = new int[steps+1];
        Arrays.fill(memo, -1);
        int ns = ways(steps, memo);
        return ns;
    }

    //driver function
    public static void main(String[] args){
        int steps = 5;

        System.out.println(findWays(steps));
    }
}