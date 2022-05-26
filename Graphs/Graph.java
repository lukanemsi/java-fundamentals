package com.company;

import java.util.*;

public class Graph
{
    private ArrayList<Node> graph;
    public Graph(List<Node> graph)
    {
        this.graph = (ArrayList<Node>) graph;
        this.graph.sort(Comparator.comparingInt(o -> (int) o.getWeight()));
    }
    public static boolean isCyclic(ArrayList<Node> nodes)
    {
        ArrayList<Integer> vertexes = new ArrayList<>();
        ArrayList<Float> edges = new ArrayList<>();
        for(Node j : nodes)
        {
            if(!vertexes.contains(j.getV1()))
                vertexes.add(j.getV1());
            if(!vertexes.contains(j.getV2()))
                vertexes.add(j.getV2());
            edges.add(j.getWeight());
        }
        return edges.size() == vertexes.size();
    }
    public Graph minimalSpanningTree()
    {
        ArrayList<Node> mst = new ArrayList<>();
        for(Node node : graph)
        {
            mst.add(0,node);
            if(Graph.isCyclic(mst)){
                mst.remove(0);
            }
        }
        return new Graph(mst);
    }
    public void toAdjacencyMatrix()
    {
        var vertexes = vertexesInGraph();
        int[][] matrix = new int[vertexes.size()+1][vertexes.size()+1];
        matrix[0][0] = -1;
        for (int i = 1; i < matrix.length; i++) {
            matrix[0][i] = vertexes.get(i - 1);
            matrix[i][0] = vertexes.get(i-1);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if(i == j)
                    matrix[i][j] = 1;
                else if(haveEdgeBetween(vertexes.get(i-1),vertexes.get(j-1)))
                    matrix[i][j] = 1;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
            {   if(i == 0 && j == 0) {System.out.print("   "); continue; }

                System.out.print(matrix[i][j] + " ");
                if(j==0)
                    System.out.print("|");
            }
            System.out.println();
        }

    }
    private boolean vertexWithEdge(int vertex,float edge)
    {
        for (Node node : graph) {
            if (node.getWeight() == edge && (node.getV1() == vertex || node.getV2() == vertex))
                return true;
        }
        return false;
    }
    private boolean haveEdgeBetween(int node1,int node2)
    {
        for (Node node : graph) {
            if(node.getV1() == node1 && node.getV2() == node2)
                return true;
            if(node.getV1() == node2 && node.getV2() == node1)
                return true;
        }
        return false;
    }
    private ArrayList<Float> edgesInGraph()
    {
        ArrayList<Float> edges = new ArrayList<>();
        for(Node node : graph)
            edges.add(node.getWeight());

        return edges;
    }
    private ArrayList<Integer> vertexesInGraph()
    {
        ArrayList<Integer> vertexes = new ArrayList<>();
        for(Node node : graph)
        {
            if(!vertexes.contains(node.getV1()))
                vertexes.add(node.getV1());
            if(!vertexes.contains(node.getV2()))
                vertexes.add(node.getV2());
        }
        return vertexes;
    }

    @Override
    public String toString() {
        return "Graph: " + graph ;
    }
}
