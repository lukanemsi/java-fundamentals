package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Node> nodes1 = new ArrayList<>(Arrays.asList(
                                        new Node(0,4,1),
                                        new Node(0,4,7),
                                        new Node(1,8,2),
                                        new Node(1,11,7),
                                        new Node(2,7,3),
                                        new Node(2,4,5),
                                        new Node(2,2,8),
                                        new Node(3,9,4),
                                        new Node(3,14,5),
                                        new Node(4,10,5),
                                        new Node(5,2,6),
                                        new Node(6,1,7),
                                        new Node(6,6,8),
                                        new Node(7,7,8)
                                        ));
        ArrayList<Node> nodes2 = new ArrayList<>(Arrays.asList(
                                        new Node(0,1,1),
                                        new Node(0,4,2),
                                        new Node(1,2,2),
                                        new Node(1,1,3),
                                        new Node(2,3,3)
                                        ));

        Graph graph1 = new Graph(nodes1);
        Graph graph2 = new Graph(nodes2);
        System.out.println(graph2.minimalSpanningTree());
        graph2.minimalSpanningTree().toAdjacencyMatrix();
    }

}