package BinaryHeap;

public class BinHeap {
    
    int arr[];
    int sizeofTree;

    public BinHeap(int size){
        this.arr=new int[size+1];
        this.sizeofTree=0;
    }

    public boolean isEmpty(){
        if(sizeofTree==0){
            return true;
        }
        return false;
    }


    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[1];
    }

    public int size(){
        return sizeofTree;
    }

    public void levelorder(){
        for (int i = 1; i <= sizeofTree; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public void heap(int index,String type){
        int parent=index/2;
        if(index<=1){
            return;
        }
        if(type=="Min"){
            if(arr[index]<arr[parent]){
                int temp=arr[index];
                arr[index]=arr[parent];
                arr[parent]=temp;
            }
        }
        if(type=="Max"){
            if(arr[index]>arr[parent]){
                int temp=arr[index];
                arr[index]=arr[parent];
                arr[parent]=temp;
            }
        }
        heap(parent, type);
    }

    public void insert(int val,String type){
        arr[sizeofTree+1]=val;
        sizeofTree++;
        heap(sizeofTree,type);
    }

    public void heapifyTopToBottom(int index, String heapType) {
        int left = index*2;
        int right = index*2 + 1;
        int swapChild = 0;
        if (sizeofTree < left) {
          return;
        }
        if (heapType == "Max") {
          if (sizeofTree == left) {
            if (arr[index] < arr[left]) {
              int tmp = arr[index];
              arr[index] = arr[left];
              arr[left] = tmp;
            }
            return;
          } else {
            if (arr[left]>arr[right]) {
              swapChild = left;
            } else {
              swapChild = right;
            }
            if (arr[index] < arr[swapChild]) {
              int tmp = arr[index];
              arr[index] = arr[swapChild];
              arr[swapChild] = tmp;
            }
          }
        } else if (heapType == "Min") {
          if (sizeofTree == left) {
            if (arr[index] > arr[left]) {
              int tmp = arr[index];
              arr[index] = arr[left];
              arr[left] = tmp;
            }
            return;
          } else {
            if (arr[left] < arr[right]) {
              swapChild = left;
            } else {
              swapChild = right;
            }
            if (arr[index] > arr[swapChild]) {
              int tmp = arr[index];
              arr[index] = arr[swapChild];
              arr[swapChild] = tmp;
            }
          }
        }
        heapifyTopToBottom(swapChild, heapType);
      }
    
      public int extractHeadOfBP(String heapType) {
        if (isEmpty()) {
          return -1;
        } else {
          int extractedValue = arr[1];
          arr[1] = arr[sizeofTree];
          sizeofTree--;
          heapifyTopToBottom(1, heapType);
          return extractedValue;
        }
      }
    
      // delete
      public void deleteBH() {
        arr = null;
        System.out.println("BH has been successfully deleted");
      }
}
