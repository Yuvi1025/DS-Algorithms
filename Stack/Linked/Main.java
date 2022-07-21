package Stack.Linked;

public class Main {
    public static void main(String[] args) {
        Stack newStack=new Stack();
        newStack.createStack(5);
        newStack.push(6);
        newStack.push(7);
        newStack.peek();
        newStack.pop();
        newStack.peek();
        newStack.pop();
        newStack.peek();
        newStack.push(6);
        newStack.push(7);
        newStack.delete();
        newStack.peek();
    }
}
