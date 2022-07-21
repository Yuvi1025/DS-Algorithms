package BST;
import java.util.Queue;
import java.util.LinkedList;

public class BST {
    public Node root;
    
    public BST(){
        this.root=null;
    }

    void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.value+" ");
        inorder(node.right);
    }

    void postorder(Node node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value+" ");
    }

    void levelorder(){
        Queue<Node> nqueue= new LinkedList<Node>();
        nqueue.add(root);
        while(!nqueue.isEmpty()){
            Node presentNode = nqueue.remove();
            System.out.print(presentNode.value+" ");
            if(presentNode.left!=null){
                nqueue.add(presentNode.left);
            }
            if(presentNode.right!=null){
                nqueue.add(presentNode.right);
            }
        }
    }

    boolean search(String val){
        Queue<Node> nqueue= new LinkedList<Node>();
        nqueue.add(root);
        while(!nqueue.isEmpty()){
            Node presentNode = nqueue.remove();
            if(presentNode.value.equals(val)){
                System.out.println("Found");
                return true;
            }
            else{
                if(presentNode.left!=null){
                    nqueue.add(presentNode.left);
                }
                if(presentNode.right!=null){
                    nqueue.add(presentNode.right);
                } 
            }
        }
        return false;
    }

    void insert(String val){
        Node node=new Node();
        node.value=val;
        if(root==null){
            root=node;
            System.out.println("Inserted");
            return;
        }
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node presentNode=queue.remove();
            if(presentNode.left==null){
                presentNode.left=node;
                System.out.println("Inserted");
                return;
            }
            else if(presentNode.right==null){
                presentNode.right=node;
                System.out.println("Inserted");
                return;
            }
            else{
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    Node getDeepestNode(){
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        Node tempNode=new Node();
        while(!queue.isEmpty()){
            tempNode=queue.remove();
            if(tempNode.left!=null){
                queue.add(tempNode.left);
            }
            if(tempNode.right!=null){
                queue.add(tempNode.right);
            }
        }
        return tempNode;
    }

    public void deleteDeepestNode(){
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        Node tempNode=null;
        Node previousNode=null;
        while(!queue.isEmpty()){
            previousNode=tempNode;
            tempNode=queue.remove();
            if(tempNode.left==null){
                previousNode.right=null;
                return;
            }
            if(tempNode.right==null){
                tempNode.left=null;
                return;
            }
            queue.add(tempNode.left);
            queue.add(tempNode.right);
        }
    }

    void deleteGiven(String val){
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node=queue.remove();
            if(node.value.equals(val)){
                node.value=getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("Removed");
                return;
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.println("Not found");
    }

    void deleteBT(){
        root=null;
    }
}
