package CLL;

public class CLL {
    public Node head;
    public Node tail;
    int size=1;

    public Node CreateCll(int value){
        Node node=new Node();
        node.value=value;
        node.next=node;
        head=node;
        tail=node;
        size=1;
        return node;
    }

    public void InsertCll(int pos,int val){
        Node node=new Node();
        if(head==null){
            CreateCll(val);
            return;
        }
        else if(pos==0){
            node.value=val;
            node.next=head;
            head=node;
            tail.next=node;
        }
        else if(pos>=size){
            node.value=val;
            tail.next=node;
            tail=node;
            tail.next=head;
        }
        else{
            node.value=val;
            Node tempNode=head;
            int index=0;
            while(index<pos-1){
                tempNode=tempNode.next;
                index++;
            }
            node.next=tempNode.next;
            tempNode.next=node;
        }
        size++;
    }

    public void CircularCll(){
        Node node=head;
        if(head!=null){
            for (int i = 0; i < size; i++) {
                System.out.print(node.value);
                node=node.next;
                if(i!=size-1){
                System.out.print(" --> ");
                }
            }
        }
        else{
            System.out.println("No node value");
        }
    }

    public boolean SearchCll(int value){
        Node node=head;
        if(head!=null){
            for (int i = 0; i < size; i++) {
                if(node.value==value){
                    System.out.println("The value "+value+" found at "+(i+1));
                    return true;
                }
                else{
                    node=node.next;
                }
            }
            System.out.println("Value not found");
            return false;
        }
        else{
            System.out.println("No CLL");
            return false;
        }
    }

    public void DeleteCll(int pos){
        Node node=head;
        if(head!=null){
            if(pos==0){
                head=node.next;
                tail.next=head;
                size--;
                if(size==0){
                    head=tail=null;
                }
            }
            else if(pos>=size-1){
                for (int i = 0; i < size-1; i++) {
                    node=node.next;
                }
                node.next=head;
                tail=node;
                size--;
                if(size==0){
                    head=tail=null;
                }
            }
            else{
                for (int i = 0; i < pos-1; i++) {
                    node=node.next;
                }
                node.next=node.next.next;
                size--;
            }
        }
    }

    public void DeleteWholeCll(){
        head=null;
        tail=null;
    }
}
