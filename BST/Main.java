package BST;

public class Main {
    public static void main(String[] args) {
        BST newBST=new BST();
        newBST.insert("1");
        newBST.insert("2");
        newBST.insert("3");
        newBST.insert("4");
        newBST.insert("5");
        newBST.insert("6");
        newBST.levelorder();
        System.out.println();
        newBST.deleteGiven("3");
        System.out.println();
        newBST.levelorder();
    }
}
