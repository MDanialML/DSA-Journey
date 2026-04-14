import java.util.ArrayList;

class MinHeap{
    public static ArrayList<Integer> minHeap = new ArrayList<>();
        public void insert(int val){
        minHeap.add(val);
        int index = minHeap.size()-1;

        while(index > 0){
            int parent = (index-1)/2;
            if(minHeap.get(index) < minHeap.get(parent)){
                swap(index, parent);
                index = parent;
            }else{
                return;
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
        heap.insert(8);
        heap.insert(3);
        heap.insert(4);
        heap.insert(1);

    }
}