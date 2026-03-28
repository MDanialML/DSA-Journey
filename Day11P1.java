//find first non repeating element
import java.util.HashMap;
import java.util.Map;


public class Day11P1{


    public static int findFirstNonRepeatingNumber(int[] arr){

        //edge case
        if(arr.length == 0){
            throw new RuntimeException("Array should not null!");
        }
        //HashMap to store frequency
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int element : arr){
            freqMap.put(element, freqMap.getOrDefault(element, 0)+1);
        }

        for(int element : arr) {
        if(freqMap.get(element) == 1) {
            return element;
            }
        }
        return -1;
    }

    //driver function
    public static void main(String[] args){
        int[] arr = {4, 5, 1, 2, 0, 4, 1, 2, 5, 3};

        int numExist = findFirstNonRepeatingNumber(arr);

        if(numExist != -1){
            System.out.println("Number Exist: " + numExist);
        }else{
            System.out.println("Number not Exist!");
        }
    }
}