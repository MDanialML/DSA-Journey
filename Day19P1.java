import java.util.ArrayList;

class MinHeap{
    public static ArrayList<Integer> minHeap = new ArrayList<>();
        public void insert(int val){
        minHeap.add(val);
        int index = minHeap.size()-1;

       if(index > 0){
        bubbleUp(index);
       }
    }

    int peek() {
        return minHeap.get(0);
     }

    int size() { 
        return minHeap.size();
    }

    public int extractMin(){

        int top = minHeap.get(0);
        int last = minHeap.size() - 1;
        minHeap.set(0, minHeap.get(last));
        minHeap.remove(last);

        bubbleDown(0);
        return top;
    }

    public void bubbleDown(int index){
        int size = minHeap.size();

        while(true){
            int left = 2*index+1;
            int right = 2*index+2;
            int smallest = index; //suppose smallest is the current element

            if(left < size && minHeap.get(left) < minHeap.get(smallest)){
                smallest = left;
            }
            if(right < size && minHeap.get(right) < minHeap.get(smallest)){
                smallest = right;
            }
            if(smallest != index){
                swap(index, smallest);
                index = smallest;
            }
            else{
                break;
            }
        }
    }

    //bubble up
    public void bubbleUp(int index){
         while(index > 0){
            int parent = (index-1)/2;
            if(minHeap.get(index) < minHeap.get(parent)){
                swap(index, parent); 
                index = parent;
            }else{
                break;
            }
            
        }
    }
    
    //compare function
    public  void swap(int i, int j){
        int temp = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, temp);
    }


}

public class Day19P1{

    

    //driver function
    public static void main(String[] args){

           MinHeap heap = new MinHeap();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(4);

        System.out.println(heap.peek());        // 1
        System.out.println(heap.extractMin());  // 1
        System.out.println(heap.peek());        // 3
        System.out.println(heap.extractMin());  // 3
        System.out.println(heap.size());    
    }
}