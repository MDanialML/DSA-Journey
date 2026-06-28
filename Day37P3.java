public class Day37P3{

    public static int[] countBit(int n){
        int[] result = new int[n+1];
        for(int i =0; i <= n; i++){
            int temp = i;
            int count = 0;
            while(temp != 0){
                temp = temp &(temp-1);
                count++;
            }
            result[i] = count;
        }
        return result;
    }

    //driver function
    public static void main(String[] args){
        int n = 5;
        int[] bitCounts = countBit(n);
        for(int i =0; i <= n; i++){
            System.out.print(i);
            System.out.print(" ---> ");
            System.out.print(bitCounts[i]); 
            System.out.println();
        }

    }
}