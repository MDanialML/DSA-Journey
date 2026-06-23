import java.util.Collections;
import java.util.PriorityQueue;
import java.util.HashMap;

public class Day33P4{

    public static int[] topKFrequent(int[] list, int k){
        //store frequency
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i =0; i< list.length; i++){
            freqMap.put(list[i], freqMap.getOrDefault(list[i], 0) + 1);
        }

        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        for(int key: freqMap.keySet()){
            minHeap.offer(key);
            if(minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        for(int i = k-1; i >= 0; i--){
            result[i] = minHeap.poll();
        }
        return result;
    }

    //driver function
    public static void main(String[] args){
        int[] nums = {1,2,2,1,2,3,1,3,2};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        for(int val: res){
            System.out.print(val + ", ");
        }
        System.out.println();
        
    }
}