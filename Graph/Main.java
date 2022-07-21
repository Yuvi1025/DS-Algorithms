package Graph;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        ArrayList<GraphNode> list=new ArrayList<GraphNode>();
        list.add(new GraphNode("A", 0));
        list.add(new GraphNode("B", 1));
        list.add(new GraphNode("C", 2));
        list.add(new GraphNode("D", 3));
        list.add(new GraphNode("E", 4));
        LGraph graph=new LGraph(list);
        graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(0, 3);
        graph.addEdges(1, 4);
        graph.addEdges(2, 3);
        graph.addEdges(3, 4);
        graph.bfs();

    }


}