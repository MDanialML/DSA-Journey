public class Day22P1{

public static void uniquePairs(int[] arr, int target) {
    if(arr.length == 0)
        throw new IllegalArgumentException("Provide a valid array!");

    int left = 0;
    int right = arr.length - 1;

    while(left < right) {
        int sum = arr[left] + arr[right];

        if(sum == target) {
            System.out.println("[" + arr[left] + ", " + arr[right] + "]");
            left++;
            right--;
            // skip duplicates after match
            while(left < right && arr[left] == arr[left - 1]) left++;
            while(left < right && arr[right] == arr[right + 1]) right--;
        } else if(sum < target) {
            left++;
        } else {
            right--;
        }
    }
}

    //driver functions
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 8;
        uniquePairs(arr, target);

    }
}