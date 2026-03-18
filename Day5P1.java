class Node{
    int data;
    Node next;

    Node(int data){
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
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    //pop
    public void pop(){
        //edge case:
        if(top == null){
            throw new IndexOutOfBoundsException("Stack is empty!");
        }

        Node temp = top;
        top = top.next;
        temp.next = null;
    }

    //peek
    public int peek(){
        //edge
        if(top == null){
            throw new RuntimeException("Stack is empty!");
        }
        return top.data;
    }

    //isEmpty
    public Boolean isEmpty(){
        if(top == null)
        {
            return true;
        }
        return false;
    }
}

public class Day5P1{

    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek()); // 30
        stack.pop();
        System.out.println(stack.peek()); // 20
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();

    }
}