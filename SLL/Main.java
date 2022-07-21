package SLL;
public class Main{
    public static void main(String[] args) {
        Sll list=new Sll();
        list.CreateSll(5);
        list.InsertSll(1, 6);
        list.InsertSll(2, 7);
        System.out.println(list.SearchSll(7));
        list.TraverseSll();
        System.out.println();
        list.DeleteWholeSll();
        list.TraverseSll();
    }
}