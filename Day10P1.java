//Merge sort
public class Day10P1{

    //Merge sort Algorithm
    public static void mergeSort(int[] arr, int left, int right){
        //base and edge cases
        if(left >= right){
            return;
        }

        //Recursive break down left and right part
        int mid = left + (right-left)/2;
        mergeSort(arr, left, mid); //from index zero to mid inclusive
        mergeSort(arr, mid+1, right); //second half start after mid
        merge(arr, left, mid, right); //merge the sorted parts
    }

    //merge the sorted array
    //hardest part
    public static void merge(int[] arr, int left, int mid, int right){
        //left temp array size
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        //temp arrays to store right and left parts
        int[] leftTemp = new int[leftSize];
        int[] rightTemp = new int[rightSize];

        //copy data into left and right arrays
        for(int i =0; i <leftSize; i++){
            leftTemp[i] = arr[i + left];
        }
        for(int j = 0; j < rightSize; j++){
            rightTemp[j] = arr[mid+1+j];
        }

        //compare and merge
        int i =0;
        int j = 0;
        int k = left; //temp should start from left index otherwise it will accidently overwrite some part of final array

        while( i < leftSize && j < rightSize){
            //compare and copy
            if(leftTemp[i] < rightTemp[j]){
                arr[k] = leftTemp[i];
                i++;
            }else{
                arr[k] = rightTemp[j];
                j++;
            }
            k++;
        }
        //copy remaining leftTemp element into main array
        while(i < leftSize){
            arr[k] = leftTemp[i];
            i++;
            k++;
        }
        //copy remaining rightTemp elements
        while(j < rightSize)
        {
            arr[k] = rightTemp[j];
            j++;
            k++;
        }
    }


    //driver function
    public static void main(String[] args){
        int[] arr = {3, 1, 9, 5, 19, 6, 20};
        int left = 0;
        int right = arr.length-1;

        mergeSort(arr, left, right);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }
}