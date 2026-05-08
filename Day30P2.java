import java.util.Map;
import java.util.HashMap;

public class Day30P2{

    public static int countSubarrays(int[] arr, int k){
        if(arr.length == 0) return 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int result = 0;
        int currSum = 0;
        prefixSums.put(0, 1);
        for(int i =0; i < arr.length; i++){
            currSum += arr[i];

            if(prefixSums.containsKey(currSum - k)){
                result += prefixSums.get(currSum - k);
            }

            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0)+1);
        }
        return result;
    }


    //driver function
    public static void main(String[] args){
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(countSubarrays(arr, k));

    }
}

