package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    ArrayList <GraphNode> list=new ArrayList<GraphNode>();
    int matrix[][];

    public Graph(ArrayList<GraphNode> list){
        this.list=list;
        matrix=new int[list.size()][list.size()];
    }

    public void addEdges(int i,int j){
        matrix[i][j]=1;
        matrix[j][i]=1;
    }

    public String toString(){
        StringBuilder s=new StringBuilder();
        s.append(" ");
        for (int i = 0; i < list.size(); i++) {
            s.append(list.get(i).name+" ");
        }
        s.append("\n");
        for (int i = 0; i < list.size(); i++) {
            s.append(list.get(i).name+": ");
            for(int j:matrix[i]){
                s.append((j)+" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public ArrayList<GraphNode> getNeighbors(GraphNode node){
        ArrayList<GraphNode> neighbors=new ArrayList<GraphNode>();
        int nodeIndex=node.index;
        for (int j = 0; j < matrix.length; j++) {
            if(matrix[nodeIndex][j]==1){
                neighbors.add(list.get(j));
            }
        }
        return neighbors;
    }

    void bfsvisit(GraphNode node){
        LinkedList<GraphNode> queue=new LinkedList<GraphNode>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode currentNode=queue.remove(0);
            currentNode.isVisited=true;
            System.out.print(currentNode.name+" ");
            if(!currentNode.isVisited){
                ArrayList<GraphNode> neighbors=getNeighbors(currentNode);
                for (GraphNode neighbor: neighbors) {
                    if(!neighbor.isVisited){
                        queue.add(neighbor);
                        neighbor.isVisited=true;
                    }
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
