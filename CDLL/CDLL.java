package CDLL;


public class CDLL {
    public Node head;
    public Node tail;
    public int size;

    public Node CreateCDLL(int val){
        Node node =new Node();
        node.value=val;
        head=node;
        tail=node;
        node.next=node;
        node.prev=node;
        size=1;
        return head;
    }

    public void InsertCDLL(int pos,int val){
        Node node=new Node();
        node.value=val;
        if(head==null){
            CreateCDLL(val);
            return;
        }
        else if(pos==0){
            node.prev=tail;
            node.next=head;
            head.prev=node;
            tail.next=node;
            head=node;
        }
        else if(pos>=size){
            node.next=head;//
            node.prev=tail;
            tail.next=node;
            head.prev=node;
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

    public void TraverseCDLL(){
        if(head!=null){
            Node node=head;
            for(int i=0;i<size;i++){
                System.out.print(node.value);
                if(i!=size-1){
                    System.out.print(" --> ");
                }
                node=node.next;
            }
        }
        else{
            System.out.println("Empty");
        }
    }

    public void ReverseTraversel(){
        if(head!=null){
            Node node=tail;
            for (int i = 0; i < size; i++) {
                System.out.print(node.value);
                if(i!=size-1){
                    System.out.print(" <-- ");
                }
                node=node.prev;
            }
        }
        else{
            System.out.println("Empty");
        }
    }

    public boolean SearchNode(int val){
        if(head!=null){
            Node node=head;
            for (int j = 0; j < size; j++) {
            if(node.value==val){
                System.out.println("The value "+val+" found at index "+j);
                return true;
            }
            node=node.next;
        }
        System.out.println("Not found");
        return false;
        }
        else{
            System.out.println("Empty");
            return false;
        }
    }

    public void DeletNode(int pos){
        if(head!=null){
            if(pos==0){
                if(size==1){
                    head.next=null;
                    head.prev=null;
                    tail=null;
                    head=null;
                    size--;
                    return;
                }
                else{
                head=head.next;
                head.prev=tail;
                tail.next=head;
                size--;
                }
            }
            else if(pos>=size){
                if(size==1){
                    head.next=null;
                    head.prev=null;
                    tail=null;
                    head=null;
                    size--;
                    return;
                }
                else{
                tail=tail.prev;
                tail.next=head;
                head.prev=tail;
                size--;
                }
            }
            else{
                Node tempNode = head;
                for (int i = 0; i < pos-1; i++) {
                    tempNode=tempNode.next;
                }
                tempNode.next=tempNode.next.next;
                tempNode.next.prev=tempNode;
            }
        }
    }

    public void DeleteAll(){
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.prev=null;
            tempNode=tempNode.next;
        }
        head=null;
        tail=null;
    }
}
