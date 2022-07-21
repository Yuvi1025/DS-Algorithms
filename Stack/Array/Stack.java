package Stack.Array;
public class Stack {
    int arr[];
    int topOfStack;
    public void Stack(int size){
        this.arr=new int[size];
        this.topOfStack=-1;
    }
    public boolean isEmpty(){
        if(topOfStack==-1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(topOfStack==arr.length-1){
            return true;
        }
        return false;
    }
    public void push(int val){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }
        else{
        arr[topOfStack+1]=val;
        topOfStack=topOfStack+1;
        }
    }
    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        else{
        arr[topOfStack]=Integer.MIN_VALUE;
        topOfStack=topOfStack-1;
        }
    }
    public void peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        else{
        System.out.println(arr[topOfStack]);
        }
    }
    public void delete(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        else{
            arr=null;
        }
    }
    }

