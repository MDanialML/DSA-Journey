class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;

    public LinkedList(){
        this.head = null;
    }

    //insert at head
    public void insertAtStart(int data){
        Node newNode = new Node(data);
        if(this.head == null)
        {
            this.head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    //insertAtEnd
    public void insertAtEnd(int data){
        Node lastNode = new Node(data);
        //edge case
        if(this.head == null){
            this.head = lastNode;
        }

        Node temp = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = lastNode;
        System.out.println("Node linked at the end!");
    }

    //delete at start
    public void deleteAtStart(){
        if(this.head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = this.head;
        head = head.next;
        temp.next = null;
        System.out.println("First Item deleted succesfully!");
    }

    public void printNodes(){
        Node temp = this.head;
        System.out.print("{ -> ");
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println(" }");
    }
}

public class Day4P1{
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.insertAtStart(10);
        list.insertAtStart(5);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.printNodes();
        list.deleteAtStart();
        list.printNodes();
    }
    
}