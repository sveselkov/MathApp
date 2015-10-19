package com.mycom.graph;


import java.util.*;

/**
 * Created by sveselkov on 10/17/2015.
 *  Study for Graph related algorithms on Java
 *  Initial description of classes from http://geekrai.blogspot.com/2014/08/graphjava.html
 *  It'a an oriented graph with weight coefficients
 */
public class Graph<V>{

    private Map<V, List<Node<V>>> adjacencyList;
    private Set<V> vertices;
    private static final int DEFAULT_WEIGHT = Integer.MAX_VALUE;

    public Graph(){
        adjacencyList = new HashMap<>();
        vertices = new HashSet<>();
    }

    public Map<V, List<Node<V>>> getGraph(){
        return this.adjacencyList;
    }

    public Set<V> getVertices() {
        return vertices;
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
        this.addEdge(src,dest,DEFAULT_WEIGHT);
    }


    public void removeEdge (V src, V dest){
        Objects.requireNonNull(src);
        Objects.requireNonNull(dest);
        List<Node<V>> adjVerices = adjacencyList.get(src);
        try {
            if ( adjVerices.contains(dest)){
                adjVerices.remove(dest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasRelation ( V src, V dest ){
        Objects.requireNonNull(src);
        Objects.requireNonNull(dest);
        List<Node<V>> adjVerices = adjacencyList.get(src);
        return (adjVerices.contains(dest));
    }


    public void debugPrint(){
        for ( V v: vertices){
            System.out.println("Vertice: " + v.toString());
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
