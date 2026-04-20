class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}



public class Day23P1{


   public static ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
        return slow;
    }

    public static boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }


    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        ListNode cycleNode = head.next.next;
        head.next.next.next.next.next = cycleNode;

        System.out.println("List has Cycle: " + hasCycle(head));


        // List WITHOUT cycle — for findMiddle
        ListNode linear = new ListNode(1);
        linear.next = new ListNode(2);
        linear.next.next = new ListNode(3);
        linear.next.next.next = new ListNode(4);
        linear.next.next.next.next = new ListNode(5);
        System.out.println("Middle of List is: "+ findMiddle(linear).val);

    }

}