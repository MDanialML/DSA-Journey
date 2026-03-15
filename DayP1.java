public class DayP1{

    public static int findMax(int[] arr){
        if(arr.length == 0){
            throw new IllegalArgumentException("Array should not be empty!");
        }

        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }


    public static void main(String[] args)
    {
        int[] arr = {};
        int max = findMax(arr);
        System.out.println(max);
    }
}