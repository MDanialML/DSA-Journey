class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null; 
    }
}


class Queue{
    Node front;
    Node rear;

    Queue(){
        this.front = null;
        this.rear = null;
    }


    //enque
    public void enqueue(int data){
        Node newNode = new Node(data);
        //edge case
        if(rear == null){
            this.front = newNode;
            this.rear = newNode;
        }
        else{
            rear.next = newNode;
            this.rear = newNode;
        }
    }

    //deque
    public int dequeue(){
        //edge case 1
        if(this.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        Node temp = this.front;
        int data = this.front.data;
        
        //check both pointers
        if(front == rear){
            front = null;
            rear = null;
            return data;
        }
        front = front.next;
        temp.next = null;
        return data; 
    }

    //access data
    public int peek(){
        //edge case
        if(front == null){
            throw new RuntimeException("Queue is empty!");
        }
        return front.data;
    }

    //check queue
    public Boolean isEmpty(){
        return front == null;
    }
}


public class Day6P1{

    public static void main(String[] args){

        Queue queue = new Queue();
        queue.enqueue(110);
        queue.enqueue(120);
        queue.enqueue(130);
        System.out.println(queue.peek());  
        queue.dequeue();
        System.out.println(queue.peek());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); 

    }
}