package com.company;

import java.util.Comparator;

public class Node
{
    private int v1;
    private int v2;
    private float weight;
    public Node(int v1,float weight,int v2)
    {
        if(v1 == v2){System.out.println("Same vertexes cant have edge weight"); return;}
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }


    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Node{" + v1 +
                ", E=" + weight + ", " +
                 v2 +
                "}";
    }
}
