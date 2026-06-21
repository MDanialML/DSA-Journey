import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ValidParenthesis{


    public static boolean checkValid(String s){

        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> match = new HashMap<>();
        match.put(')', '(');
        match.put('}', '{');
        match.put(']', '[');

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
            //    if(){
            //     return false;
            //    }
               if(stack.isEmpty() || match.get(ch) != stack.peek()){
                return false;
               }else{
               stack.pop();
               }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }

    }


    //driver function
    public static void main(String[] args){
        String s = "([)]";
        boolean answer = checkValid(s);
        System.out.println("Given brackets are valid:   " + answer);
    }
}