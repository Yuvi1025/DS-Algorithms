package CDLL;

public class Main {
    public static void main(String[] args) {
        CDLL clist=new CDLL();
        clist.CreateCDLL(5);
        clist.InsertCDLL(0, 6);
        clist.InsertCDLL(2, 7);
        clist.InsertCDLL(1, 10);
        clist.TraverseCDLL();
        System.out.println();
        clist.SearchNode(17);
    }
}
