package Queue;
public class Queue{
    int arr[];
    int begOfQueue;
    int topOfQueue;

    public void createQueue(int size){
        this.arr=new int[size];
        this.topOfQueue=-1;
        this.begOfQueue=-1;
    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("Queue is full");
        }
        else if(isEmpty()){
        begOfQueue=0;
        arr[topOfQueue+1]=val;
        topOfQueue++;
        }
        else{
        arr[topOfQueue+1]=val;
        topOfQueue++;
        }
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            begOfQueue++;
            if(begOfQueue>topOfQueue){
                begOfQueue=topOfQueue=-1;
            }
        }
    }

    public boolean isEmpty(){
        if(begOfQueue==-1||begOfQueue==arr.length){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(topOfQueue==arr.length-1){
            return true;
        }
        return false;
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        else{
            System.out.println(arr[begOfQueue]);
        }
    }

    public void delete(){
        arr=null;
    }
}