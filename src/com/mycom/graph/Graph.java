package com.mycom.graph;


import java.util.*;

/**
 * Created by Admin on 10/17/2015.
 */
public class Graph<V>{

    private Map<V, List<Node<V>>> adjacencyList;
    private Set<V> vertices;
    private static final int DEFAULT_WAIGHT = Integer.MAX_VALUE;

    public Graph(){
        adjacencyList = new HashMap<>();
        vertices = new HashSet<>();
    }

    public Map<V, List<Node<V>>> getGraph(){
        return this.adjacencyList;
    }

    public boolean isEmpty(){
        return this.vertices.isEmpty();
    }

    public void addEdge( V src, Node<V> dest){
        List<Node<V>> adjacentVertices = adjacencyList.get(src);
        if (adjacentVertices == null ){
            adjacentVertices = new ArrayList<Node<V>>();
        }
        adjacentVertices.add( dest );
        adjacencyList.put(src, adjacentVertices);
    }

 
    public void addEdge ( V src, V dest, int weight ){
        Objects.requireNonNull(src);
        Objects.requireNonNull(dest);
        this.addEdge(src, new Node<>(dest, weight));
        this.vertices.add(src);
        this.vertices.add(dest);
    }

    public void addEdge (V src, V dest){
        this.addEdge(src,dest,DEFAULT_WAIGHT);
    }


    public void debugPrint(){
        for ( V v: vertices){
            System.out.println("Verice: " + v.toString());
            List<Node<V>> adjVert = adjacencyList.get(v);
            try {
                for (Node<V> node:  adjVert){
                    System.out.print(v.toString() + "->" + node.getName().toString() + " : " + node.getWeight().toString() + " | ");
                }
            } catch (Exception e) {
               System.out.println("No connection");
            }
        }
    }

}
