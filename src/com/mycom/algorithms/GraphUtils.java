package com.mycom.algorithms;

import com.mycom.graph.Graph;
import com.mycom.graph.Node;

import java.util.*;


/**
 * Created by sveselkov on 10/18/2015.
 */
public class GraphUtils<V> {

    /*Dijkstra algorithm
    * General O(n*n) algorithm but here may be O(n*n*n) due to collection realisation
    * Not finished
    * */
    public Map<V,Integer> shortPath ( Graph<V> graph, V src){
        Map<V,Integer> shortPathes= new HashMap<>();
        Map<V, List<Node<V>>> adgList = graph.getGraph();
        Set<V> vertices = graph.getVertices();

        // Init distances
        for ( V v: vertices){
            if ( v == src){
                shortPathes.put(v, 0);
            } else {
                shortPathes.put(v, Integer.MAX_VALUE);
            }
        }
        V curr_v = src;
        vertices.remove( src );

        do {
            List<Node<V>> adjVertices = adgList.get(curr_v);
            V shortest = curr_v;
            int shLength = Integer.MAX_VALUE;
            for ( Node<V> node: adjVertices){
                Integer pathLength = node.getWeight() + shortPathes.get( curr_v);
                if ( pathLength < shortPathes.get(node.getName())){
                    shortPathes.put(node.getName(),pathLength);
                }
                if ( pathLength < shLength){
                    shLength = pathLength;
                    shortest = node.getName();
                }
            }
            curr_v = shortest;
            vertices.remove(curr_v);
        } while ( vertices.size() > 0);
        return ( shortPathes);
    }
}
