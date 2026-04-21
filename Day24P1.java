import java.util.PriorityQueue;
import java.util.List;
public class Day24P1{


    public static PriorityQueue<Integer> findKLargest(int[] arr, int k){
        if(arr.length == 0 || k > arr.length)
        throw new IllegalArgumentException("Invalid input!");        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq;
    }

    public static int findKthLargest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }


    //driver function 
    public static void main(String[] args)
    {
       int[] arr = {3, 1, 5, 12, 2, 11, 7, 8};
       int K = 3;
       PriorityQueue<Integer> pq = findKLargest(arr, K);
       for(int num : pq){
        System.out.println(num);
       }

       int num = findKthLargest(arr, K);
       System.out.println("Kth Largest number: " + num);

    }
}