public class Day28P1{

    public static int[] prefixSum(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        return prefix;
    }

    //range sum
    public static int rangeSum(int[] arr, int L, int R){
        if(L==0) return arr[R]; //special case
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("Invalid array!");
        if(L > R || L < 0 || R >= arr.length)
            throw new IllegalArgumentException("Invalid range!");

        return arr[R] - arr[L-1];
    }

    //driver code
    public static void main(String[] args){
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] prefixs = prefixSum(arr);

        for(int num: prefixs){
            System.out.print(num+", ");
        }
        System.out.println();

        System.out.println("Sum of range 2 to 6:    "+ rangeSum(prefixs, 2, 6));
        System.out.println("Sum of range 0 to 3:    "+ rangeSum(prefixs, 0, 3));
        System.out.println("Sum of range 1 to 6:    "+ rangeSum(prefixs, 1, 6));
    }
}