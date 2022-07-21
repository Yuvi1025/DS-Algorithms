package BinarySearch;

public class Main {
    public static void main(String[] args) {
        BinarySearch bst=new BinarySearch();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);
        System.out.println();
        bst.delete(bst.root,90);
        bst.levelorder();
    }
}
