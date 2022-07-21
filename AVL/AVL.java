package AVL;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    BinaryNode root;

    AVL(){
        root=null;
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

    BinaryNode search(BinaryNode node,int val){
        if(node==null){
            return null;
        }
        else if(node.value==val){
            System.out.println("Found");
            return node;
        }
        else if(node.value>val){
            search(node.left, val);
        }
        else{
            search(node.right, val);
        }
        return node;
    }

    public int getHeight(BinaryNode node){
        if(node==null){
            return 0;
        }
        return node.height;
    }

    private BinaryNode rotateRight(BinaryNode disbalanceNode){
        BinaryNode newRoot=disbalanceNode.left;
        disbalanceNode.left=disbalanceNode.left.right;
        newRoot.right=disbalanceNode;
        disbalanceNode.height=1+Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
        newRoot.height=1+Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private BinaryNode rotateLeft(BinaryNode disbalanceNode){
        BinaryNode newRoot=disbalanceNode.right;
        disbalanceNode.right=disbalanceNode.right.left;
        newRoot.left=disbalanceNode;
        disbalanceNode.height=1+Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
        newRoot.height=1+Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    public int getBalance(BinaryNode node){
        if(node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }

    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
          return root;
        } else {
          return minimumNode(root.left);
        }
      }

    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if (node == null) {
          BinaryNode newNode = new BinaryNode();
          newNode.value = nodeValue;
          newNode.height = 1;
          return newNode;
        } else if (nodeValue < node.value) {
          node.left = insertNode(node.left, nodeValue);
        } else {
          node.right = insertNode(node.right, nodeValue);
        }
    
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
    
        if (balance > 1 && nodeValue < node.left.value) {
          return rotateRight(node);
        }
    
        if (balance > 1 && nodeValue > node.left.value) {
          node.left = rotateLeft(node.left);
          return rotateRight(node);
        }
    
        if (balance < -1 && nodeValue > node.right.value) {
          return rotateLeft(node);
        }
    
        if (balance < - 1 && nodeValue < node.right.value) {
          node.right = rotateRight(node.right);
          return rotateLeft(node);
        }
    
        return node;
    
      }

      public void insert(int val){
        root=insertNode(root, val);
      }

      public BinaryNode deleteNode(BinaryNode node, int value) {
        if (node == null) {
          System.out.println("Value not found in AVL");
          return node;
        }
        if (value < node.value) {
          node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
          node.right = deleteNode(node.right, value);
        } else {
          if (node.left != null && node.right != null) {
            BinaryNode temp = node;
            BinaryNode minNodeForRight = minimumNode(temp.right);
            node.value = minNodeForRight.value;
            node.right = deleteNode(node.right, minNodeForRight.value);
          } else if (node.left != null) {
            node = node.left;
          } else if (node.right != null) {
            node = node.right;
          } else {
            node = null;
          }
        }
        int balance = getBalance(node);
     
        if (balance > 1 && getBalance(node.left) >= 0) {
          return rotateRight(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
          node.left = rotateLeft(node.left);
          return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
          return rotateLeft(node);
        }
     
        if (balance < -1 && getBalance(node.right) > 0) {
          node.right = rotateRight(node.right);
          return rotateLeft(node);
        }
     
        return node;
     
      }
     
      public void delete(int value) {
        root = deleteNode(root, value);
      }
     
      public void deleteAVL() {
        root = null;
      }
     

}
