import java.util.Arrays;
import java.util.Stack;
public class Day29P1{

    public static int[] nextGreater(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Stack<Integer> s = new Stack<>();
        for(int i =0; i < n; i++){
            
            while(!s.isEmpty() && arr[i] > arr[s.peek()]){
                int index = s.pop();
                result[index] = arr[i];
            }
            s.push(i);
        }
        return result;
    }


    //driver function
    public static void main(String[] args){
        int[] arr = {2, 1, 5, 3, 7, 4};
        int[] result = nextGreater(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " → " + result[i]);
        }
    }
}