package SLL;
public class Sll {
    public Node head;
    public Node tail;
    public int size;

    public Node CreateSll(int nodeValue){
        head=new Node();
        Node node=new Node();
        node.value=nodeValue;
        node.next=null;
        head=node;
        tail=node;
        size=1;
        return head;
    }

    public void InsertSll(int pos,int nodeValue){
        Node node=new Node();
        node.value=nodeValue;
       if(head==null){
        CreateSll(nodeValue);
        return;
       }
       else{
        if(pos==0){
            node.next=head;
            head=node;
        }
        else if(pos>=size){
            node.next=null;
            tail.next=node;
            tail=node;
        }
        else{
            Node tempNode=head;
            int index=0;
            while(index<pos-1){
                tempNode=tempNode.next;
                index++;
            }
            Node nextNode=tempNode.next;
            tempNode.next=node;
            node.next=nextNode;

        }
       }
       size++;
    }

    public void TraverseSll(){
        if(head==null){
            return;
        }
        else{
            Node node=head;
            while(node.next!=null){
                System.out.print(node.value);
                System.out.print(" --> ");
                node=node.next;
            }
            System.out.print(node.value);    
        }        
    }

    public boolean SearchSll(int value){
        if(head==null){
            return false;
        }
        else{
            Node node=head;
            while(node.next!=null){
                if(node.value==value){
                    return true;
                }
                else{
                    node=node.next;
                }
            }
            if(node.value==value){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void DeleteSll(int location){
        if(head==null){
            System.out.println("No node to delete");
            return;
        }
        else if(location==0){
            head=head.next;
            size--;
            if(size==0){
                tail=null;
            }
        }
        else if(location>=size){
            Node node=head;
            for (int i = 0; i < size-1; i++) {
                node=node.next;
            }
            if(node==head){
                head=tail=null;
                size--;
                return;
            }
            node.next=null;
            tail=node;
            size--;    
        }
        else{
            Node node=head;
            for (int i = 0; i < location-1; i++) {
                node=node.next;
            }
            node.next=node.next.next;
            size--;
        }
    }

    public void DeleteWholeSll(){
        head=null;
        tail=null;
    }
}
