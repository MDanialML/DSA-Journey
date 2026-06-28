public class Day37P1{

    public static int countBit(int num){
        int result = 0;
        while(num != 0){
            num = num & (num - 1);
            result++;
        }
        return result;
    }
    //drvier function
    public static void main(String[] args){
        int num = 2;
        System.out.println("Number of 1 bits:   " + countBit(num));
    }
}