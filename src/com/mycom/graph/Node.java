package com.mycom.graph;

/**
 * Created by Admin on 10/18/2015.
 */
public class Node<V> {
    private V name; //Vertex name;
    private Integer weight;

    public Node(V name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public V getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }
}
