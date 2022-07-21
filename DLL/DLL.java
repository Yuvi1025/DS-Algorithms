package DLL;

public class DLL {
    public Node head;
    public Node tail;
    public int size;

    public Node CreateDLL(int value){
        head=new Node();
        Node node=new Node();
        node.prev=null;
        node.next=null;
        node.value=value;
        head=node;
        tail=node;
        size=1;
        return head;
    }

    public void InsertDLL(int pos,int value){
        Node node=new Node();
        node.value=value;
        if(head==null){
            CreateDLL(value);
            return;
        }
        else if(pos==0){
            node.next=head;
            head.prev=node;
            node.prev=null;
            head=node;
        }
        else if(pos>=size){
            tail.next=node;
            node.prev=tail;
            node.next=null;
            tail=node;
        }
        else{
            Node tempNode=head;
            for (int i = 0; i < pos-1; i++) {
                tempNode=tempNode.next;
            }
            node.prev=tempNode;
            node.next=tempNode.next;
            tempNode.next=node;
            node.next.prev=node;
        }
        size++;
    }

    public void TraverseDLL(){
        if(head!=null){
            Node node=head;
            for (int i = 0; i < size; i++) {
                System.out.print(node.value);
                if(i!=size-1){
                    System.out.print(" --> ");
                }
                node=node.next;
            }
        }
        else{
            System.out.println("Empty DLL");
        }
    }

    public void ReverseTraverseDLL(){
        if(head!=null){
            Node node=tail;
            for (int i = size-1; i >= 0; i--) {
                System.out.print(node.value);
                if(i!=0){
                    System.out.print(" --> ");
                }
                node=node.prev;
            }
        }
        else{
            System.out.println("Empty DLL");
        }
    }

    public boolean SearchNode(int value){
        if(head!=null){
            Node node=head;
            for (int i = 0; i < size; i++) {
                if(node.value==value){
                    System.out.println("The value "+value+" found at index "+(i+1));
                    return true;
                }
                node=node.next;
            }
            System.out.println("Not found");
            return false;
        }
        else{
            System.out.println("Empty DLL");
            return false;
        }
    }


    public void DeleteDll(int pos){
        if(head!=null){
            if(pos==0){
                head.next.prev=null;
                head=head.next;
                size--;
                if(size==0){
                    head.next=null;
                    tail.prev=null;
                    head=tail=null;
                }
            }
            else if(pos>=size){
                tail.prev.next=null;
                tail=tail.prev;
                size--;
                if(size==0){
                    head.next=null;
                    tail.prev=null;
                    head=tail=null;
                }
            }
            else{
                Node tempNode=head;
                for (int i = 0; i < pos-1; i++) {
                    tempNode=tempNode.next;
                }
                tempNode.next.next.prev=tempNode.next;
                tempNode.next=tempNode.next.next;
                size--;
            }
        }
    }

    public void DeleteWhole(){
        Node node=head;
        for (int i = 0; i < size; i++) {
            node.prev=null;
            node=node.next;
        }
        head=tail=null;
    }
}
