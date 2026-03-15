public class Day3P1{

    public static boolean isPalindrome(String s) {

    //Edge case:
    if(s.length() == 0)
    {
        throw new IllegalArgumentException("String should not be empty!");
    }

    // String str = s.toLowerCase();

    int start = 0;
    int end = s.length() - 1;
    while(start <= end)
    {
        if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))
){
            return false;
        }
        start++;
        end--;
    }
    return true;
}

    public static void main(String[] args){
        String pallindrome = "Apple";
        Boolean isP = isPalindrome(pallindrome);
        System.out.println(pallindrome + " is a Palindrome: " + isP);
    }
}