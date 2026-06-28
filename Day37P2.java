public class Day37P2{

    public static boolean checkPowerOfTwo(int num){
        if(num <= 0) return false;
        if(((num & (num-1)) == 0)) return true;
        else return false;
    }

    //driver function
    public static void main(String[] args){
        int number = 392;
        System.out.println(number + "  Given number is power of two:  " + checkPowerOfTwo(number));
    }
}