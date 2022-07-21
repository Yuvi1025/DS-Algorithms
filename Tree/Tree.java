package Tree;

import java.util.ArrayList;

public class Tree {
    String data;
    ArrayList <Tree> child;

    public Tree(String data){
        this.data=data;
        this.child=new ArrayList<Tree>();
    }

    public void addChild(Tree child){
        this.child.add(child);
    }

    public String print(int level){
        String res;
        res=" ".repeat(level)+data+"\n";
        for(Tree child: this.child){
            res+=child.print(level+1);
        }
        return res;
    }
}
