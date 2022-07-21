package Graph;

import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited=false;

    public ArrayList<GraphNode> neighbors=new ArrayList<GraphNode>();

    public GraphNode(String name,int index){
        this.index=index;
        this.name=name;
    }
}
