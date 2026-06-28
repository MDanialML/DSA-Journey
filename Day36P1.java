public class Day36P1{

    public static int uniqueElement(int[] nums){
        int temp = 0;
        for(int num : nums){
            temp = temp ^ num;
        }
        return temp;
    }

    public static void main(String[] args){
        int nums[] = {1,1,7,7,3,9,9};
        System.out.println("Unique element is:  "+ uniqueElement(nums));
    }
}