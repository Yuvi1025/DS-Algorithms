package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class LGraph {
    ArrayList <GraphNode> list=new ArrayList<GraphNode>();
    int matrix[][];

    public LGraph(ArrayList<GraphNode> list){
        this.list=list;
        matrix=new int[list.size()][list.size()];
    }

    public void addEdges(int i,int j){
        GraphNode first=list.get(i);
        GraphNode second=list.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }



    public String toString(){
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            s.append(list.get(i).name+" :");
            for (int j = 0; j < list.get(i).neighbors.size(); j++) {
                if(j==list.get(i).neighbors.size()-1){
                    s.append(list.get(i).neighbors.get(j).name);
                }
                else{
                    s.append(list.get(i).neighbors.get(j).name+"-->");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    void bfsvisit(GraphNode node){
        LinkedList<GraphNode> queue=new LinkedList<GraphNode>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode currentNode=queue.remove(0);
            currentNode.isVisited=true;
            System.out.print(currentNode.name+" ");
            for(GraphNode neighbor : currentNode.neighbors){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited=true;
                }
            }
            }
        }
    

    public void bfs(){
        for(GraphNode node: list){
            if(!node.isVisited){
                bfsvisit(node);
            }
        }
    }
}
