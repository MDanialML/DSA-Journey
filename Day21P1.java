public class Day21P1{

    public static int calculateMax(int[] arr, int ws){

        //edge case
        if(arr.length == 0 || arr.length < ws){
            throw new IllegalArgumentException ("Array lenght is not valid!");
        }
        int windowSum = 0;
        int maxSum = 0;
        for(int i = 0; i < ws; i++){
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for(int i = ws; i < arr.length; i++){
            windowSum += arr[i]; //add new element 
            windowSum -= arr[i-ws]; //remove previous element
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }


    //driver class
    public static void main(String[] args){
        int[] arr = {2, 1, 5, 1, 3, 2};
        int size = 3;

        int maxSum = calculateMax(arr, size);
        System.out.println("MaxSum: " + maxSum);
    }
}