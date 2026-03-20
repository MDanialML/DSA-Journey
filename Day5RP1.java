class Node{
    char data;
    Node next;

    Node(char data){
        this.data = data;
        this.next = null;
    }
}

class Stack{
    Node top;

    Stack(){
        this.top = null;
    }

    //push
    public void push(char data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    //pop
    public char pop(){
        //edge case 
        if(top == null){
            throw new IndexOutOfBoundsException("Stack is empty!");
        }
        char data = top.data;
        Node temp = this.top;
        top = top.next;
        temp.next = null;
        return data;
    }

    //peek
    public char peek(){
        if(top == null){
            throw new RuntimeException("Stack is empty!");
        }
        else return top.data;
    }

    //check is empty
    public Boolean isEmpty(){
        return this.top == null;
    }
}

public class Day5RP1{

    public static Boolean isValid(String s){
        //edge case
        if(s.length() == 0){
            throw new RuntimeException("Input is empty!");
        }
        String OBrackets = "({[";
        Stack stack = new Stack();
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            //if Opening Bracket push into stack
            if(OBrackets.indexOf(c) != -1){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;

                char chTop = stack.pop();
                if(chTop == '(' && c != ')' ) return false;
                if(chTop == '{' && c != '}') return false;
                if(chTop == '[' && c != ']') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String bracket = "([]{)";
        System.out.println("Brackets are valid: " + isValid(bracket));

    }
}