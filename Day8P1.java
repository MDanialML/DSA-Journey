public class Day8P1{

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void permute(int[] arr, int start){
        // //edge case
        // if(arr.length == 0){
        //     throw new IllegalArgumentException("Input array should not empty!");
        // }

        //Base case
        if(start == arr.length){
            //print array
            System.out.print("[");
            for(int i =0; i < arr.length; i++){
                System.out.print(arr[i] +", ");
            }
            System.out.println("]");
            return;
        }


        for(int i = start; i < arr.length; i++){
            swap(arr, start, i);
            //recursive call 
            permute(arr, start+1);
            //back track
            swap(arr, i, start);
        }
       


    }

    public static void main(String[] args)
    {
        
        int num[] = {1,2,3};
        permute(num, 0);
    }
}