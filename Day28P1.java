public class Day28P1{

    public static int[] prefixSum(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        return prefix;
    }

    //driver code
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        int[] prefixs = prefixSum(arr);

        for(int num: prefixs){
            System.out.print(num+", ");
        }
        System.out.println();
    }
}