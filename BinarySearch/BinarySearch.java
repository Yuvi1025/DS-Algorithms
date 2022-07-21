package BinarySearch;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearch {
    BinaryNode root;

    BinarySearch(){
        root=null;
    }

    public void insert(int val){
        BinaryNode newNode=new BinaryNode();
        newNode.value=val;
        if(root==null){
            root=newNode;
            System.out.println("Inserted");
            return;
        }
        BinaryNode tempNode=root;
        
        while(true){
        if(tempNode.value>val){
            if(tempNode.left==null){
                tempNode.left=newNode;
                System.out.println("Inserted");
                return;
            }
            tempNode=tempNode.left;
        }
        else{
            if(tempNode.right==null){
                tempNode.right=newNode;
                System.out.println("Inserted");
                return;
            }
            tempNode=tempNode.right;
        }
    }
    }

    public void preorder(BinaryNode node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(BinaryNode node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.value+" ");
        inorder(node.right);
    }

    public void postorder(BinaryNode node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value+" ");
        
    }

    void levelorder(){
        Queue<BinaryNode> nqueue= new LinkedList<BinaryNode>();
        nqueue.add(root);
        while(!nqueue.isEmpty()){
            BinaryNode presentNode = nqueue.remove();
            System.out.print(presentNode.value+" ");
            if(presentNode.left!=null){
                nqueue.add(presentNode.left);
            }
            if(presentNode.right!=null){
                nqueue.add(presentNode.right);
            }
        }
    }

    boolean search(int val){
        if(root==null){
            System.out.println("Empty bst");
            return false;
        }
        BinaryNode node=root;
        while(node!=null){
        if(node.value==val){
            System.out.println("Found");
            return true;
        }
        else{
            if(node.value>val){
                node=node.left;
            }
            else{
                node=node.right;
            }
        }
    }
    System.out.println("Not found");
    return false;
    }

    public BinaryNode minimunm(BinaryNode node){
        if(node.left==null){
            return node;
        }
        else{
            return minimunm(node.left);
        }
    }

    public BinaryNode delete(BinaryNode node,int val){
        if(node==null){
            System.out.println("Not found");
            return null;
        }
        else if(val<node.value){
            node.left=delete(node.left, val);
        }
        else if(val>node.value){
            node.right=delete(node.right, val);
        }
        else{
        if(node.left!=null&&node.right!=null){
            BinaryNode temp=node;
            BinaryNode minRight=minimunm(temp.right);
            node.value=minRight.value;
            node.right=delete(node.right, minRight.value);
        }
        else if(node.left!=null){
            node=node.left;
        }
        else if(node.right!=null){
            node=node.right;
        }
        else{
            node=null;
        }
    }
        return node;
    }
}
