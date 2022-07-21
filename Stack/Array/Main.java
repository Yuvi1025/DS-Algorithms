package Stack.Array;


public class Main {
    public static void main(String[] args) {
        Stack newStack=new Stack();
        newStack.Stack(5);
        newStack.push(1);
        newStack.push(2);
        newStack.push(1);
        newStack.push(2);
        newStack.push(1);
        System.out.println(newStack.isFull());
        
    }
}
