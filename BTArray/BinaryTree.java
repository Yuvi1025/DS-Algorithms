package BTArray;

public class BinaryTree {
    String[] arr;
    int lastUsedIndex;

    public BinaryTree(int size){
        this.arr=new String[size+1];
        lastUsedIndex=0;
    }

    boolean isFull(){
        if(lastUsedIndex==arr.length-1){
            return true;
        }
        return false;
    }

    public void insert(String val){
        if(isFull()){
            System.out.println("Full");
            return;
        }
        arr[lastUsedIndex+1]=val;
        lastUsedIndex++;
        
    }

    public void preorder(int index){
        if(index>lastUsedIndex){
            return;
        }
        System.out.print(arr[index]+" ");
        preorder(index*2);
        preorder(index*2+1);
    }

    public void inorder(int index){
        if(index>lastUsedIndex){
            return;
        }
        inorder(index*2);
        System.out.print(arr[index]+" ");
        inorder(index*2+1);
    }

    public void postorder(int index){
        if(index>lastUsedIndex){
            return;
        }
        postorder(index*2);
        postorder(index*2+1);
        System.out.print(arr[index]+" ");
    }

    public void levelorder(){
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public int search(String val){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].equals(val)){
                System.out.println("Found at "+i);
                return i;
            }
        }
        System.out.println("Not found");
        return -1;
    }

    public void delete(String val){
        int location=search(val);
        if(location>-1){
            arr[location]=arr[lastUsedIndex];
            lastUsedIndex--;
            return;
        }
        System.out.println("Not found");

    }

    public void deleteTree(){
        arr=null;
    }
}
