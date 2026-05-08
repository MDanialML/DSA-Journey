public class Day30P3{


    //remove duplicates
    public static int removeDup(int[] arr){
        int n = arr.length;
        if(n <= 1) return n;
        int slow =0;
        for(int fast = 1; fast < n; fast++){
            if(arr[slow] != arr[fast]){
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return slow+1;
    }

    //driver function
    public static void main(String[] args){

        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int newSize = removeDup(arr);
        System.out.println(newSize);

    }
}