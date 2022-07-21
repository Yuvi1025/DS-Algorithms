package Stack.Linked;


public class Stack {
    public Node head;
    public Node tail;
    public int size=0;

    public Node createStack(int val){
        head=new Node();
        Node node=new Node();
        node.value=val;
        node.next=null;
        head=node;
        tail=node;
        size=1;
        return head;
    }

    public void push(int val){
        if(head==null){
            createStack(val);
            return;
        }
        else{
            Node node=new Node();
            node.value=val;
            node.next=head;
            head=node;
            size++;
        }
    }

    public void pop(){
        if(head==null){
            System.out.println("Stack is empty");
            return;
        }
        else{
            head=head.next;
            size--;
        }
    }

    public void peek(){
        if(head==null){
            System.out.println("Stack is empty");
            return;
        }
        else{
            System.out.println(head.value);
        }
    }

    public void delete(){
        if(head==null){
            System.out.println("Stack is empty");
            return;
        }
        else{
            head=tail=null;
            System.out.println("Stack deleted");
        }
    }

    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }


}
