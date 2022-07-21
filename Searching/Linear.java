package Searching;

public class Linear {
    
    public int Linear(int[] arr,int tar){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==tar){
                System.out.println("The value is found at "+i);
                return arr[i];
            }
        }
        System.out.println("Value not found");
        return -1;
    }

}
