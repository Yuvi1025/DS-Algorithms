package DLL;

public class Main {
    public static void main(String[] args) {
        DLL dlist = new DLL();
        dlist.CreateDLL(5);
        dlist.InsertDLL(0, 6);
        dlist.InsertDLL(2, 7);
        dlist.InsertDLL(3, 8);
        dlist.InsertDLL(2, 10);
        dlist.TraverseDLL();
        System.out.println();
        dlist.DeleteWhole();
        dlist.TraverseDLL();
        System.out.println();
    }
}
