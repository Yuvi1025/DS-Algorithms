package LLEXE;


public class Main {
    public static void main(String[] args) {
        LinkedList ll=new LLEXE.LinkedList();
        ll.createLL(5);
        ll.insertNode(6);
        ll.insertNode(7);
        ll.insertNode(7);
        ll.traversalLL();
        Questions q=new Questions();
        q.partition(ll, 7);
        ll.traversalLL();
    }
}
