public class Day2P1{

    public static int[] squareSorted(int[] arr) {
        //Edge case 1:
        if(arr.length == 0){
                throw new IllegalArgumentException("Input is empty!");
            }
    //new array
    int[] result = new int[arr.length];

    // //Edge case 2:
    // if(arr.length == 1){
    //     result[0] = arr[0] * arr[0];
    //     return result;
    // }

    //Square the array
    for(int i =0; i < arr.length; i++)
    {
        result[i] = arr[i] * arr[i];
    }

    //Sort result array
    for(int i =0; i < result.length; i++){
        for(int j =0; j < result.length - 1-i; j++)
        { 
            if(result[j] > result[j+1]){
                int temp = result[j];
                result[j] = result[j+1];
                result[j+1] = temp;
            }
        }
    }
    return result;
}

    

    public static void main(String[] args){
        int[] arr = {-4, -1, 0, 3, 5};
        int[] solved = squareSorted(arr);
        for(int ele : solved){
            System.out.print(ele + ", ");
        }
        System.out.println();
    }
}