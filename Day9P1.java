public class Day9P1{

    //Binary search algo
    public static int findTarget(int[] arr, int target){
        if(arr.length == 0){
            throw new RuntimeException("Input array is empty!");
        }
        int left = 0;
        int right = arr.length-1;
        
        while(left <= right)
        {
            int mid = left+(right-left)/2;
            if(arr[mid] == target){
                return mid;
            }
            
            if(target > arr[mid]){
                left = mid+1;
            }
            else if(target < arr[mid]){
                right = mid-1;
            }
        }
        return -1;
    }

    //Recursive solution
    public static int recursiveFind(int[] arr, int left, int right, int target){
        //base
        if(left > right){
            return -1;
        }
        
        int mid = left + (right-left)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(target > arr[mid]){
            left = mid+1;
        }
        if(target < arr[mid]){
            right = mid -1;
        }
        return recursiveFind(arr, left, right, target);
    }


    public static void main(String[] args){

        System.out.println("Iterative method.!");
        //sorted array
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        //target
        int target = 11;

        int targetFound = findTarget(arr, target);
        if(targetFound != -1){
            System.out.println(target + " Target exist!");
        }else{
            System.out.println("Target not exist!");
        }

        System.out.println("Recursive method.!");
        int[] arr2 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target2 = 6;
        int left =0;
        int right = arr2.length -1;
        int found = recursiveFind(arr2, left, right, target2);
        if(found != -1){
            System.out.println(found);
        }else{
            System.out.println(-1);
        }


    }
}