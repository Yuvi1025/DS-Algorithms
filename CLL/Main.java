package CLL;

public class Main {
    public static void main(String[] args) {
        CLL clist=new CLL();
        clist.CreateCll(5);
        clist.InsertCll(1, 6);
        clist.InsertCll(1, 7);
        clist.CircularCll();
        clist.DeleteWholeCll();
        System.out.println();
        clist.CircularCll();
        System.out.println(clist.tail);
    }
}
