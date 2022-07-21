package Searching;

public class Binary {
    
    public int Binary(int arr[],int val){
        int start=0;
        int end=arr.length-1;
        int middle=(start+end)/2;
        while(arr[middle]!=val&&start<=end){
            if(arr[middle]>val){
                end=middle-1;
            }
            else{
                start=middle+1;
            }
            middle=(start+end)/2;
        }
        if(arr[middle]==val){
            return arr[middle];
        }
        return -1;
    }

}
