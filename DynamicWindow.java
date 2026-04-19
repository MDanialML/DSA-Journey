public class DynamicWindow{


    //Dynamic sliding window
    public static int minSubarray(int[] arr, int target){
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;
        for(int right = 0; right < arr.length; right++){
            windowSum += arr[right];

            //shrink the window size if valid
            while(windowSum >= target){
                minLen = Integer.min(minLen, right - left + 1);
                windowSum -= arr[right];
                left++; //shrink the window
            }
        }
        return minLen == Integer.MAX_VALUE?0:minLen;

    }


    //driver function
    public static void main(String[] args){
        int[] arr = {1, 9, 3, 5, 7};
        int target = 8;

        int minLen = minSubarray(arr, target);
        System.out.println("Minimum length: " + minLen);
    }

}