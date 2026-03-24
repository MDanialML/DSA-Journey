public class Day6R1{


    public static int getFact(int num){
        //edge case
        if(num < 0){
            throw new IllegalArgumentException("Negative number not allowed!");
        }
        //base case
        if(num <= 1){
            return 1;
        }

        int fact = num * getFact(num -1);
        return fact;
    }
    public static void main(String[] args){
        int num = 4;
        System.out.println("Factorial of given number: " + getFact(num));
    }
}
/** Stack Trace
 factorial(4)
    factorial(3)
        factorial(2)
            factorial(1)
            return 1*1= 1
        return 2 *1= 2
    return 3 * 2 = 6
return 4 * 6 = 24
 * 
 */