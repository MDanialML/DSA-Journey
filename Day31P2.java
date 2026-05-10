public class Day31P2{

    public static int maxProfit(int[] arr){
        if(arr.length < 1) return 0;
        int minPrice = arr[0];
        int result = 0;

        for(int i =1; i < arr.length; i++){
            minPrice = Math.min(minPrice, arr[i]);

            result = Math.max(result, arr[i] - minPrice);
        }
        return result;
    }
    

    //driver function
    public static void main(String[] args){
        int[] arr =  {7, 1, 5, 3, 6, 4};
        int profit =  maxProfit(arr);
        System.out.println("Max Profit: "+profit);
    }
}