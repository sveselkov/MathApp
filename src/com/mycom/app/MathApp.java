package com.mycom.app;

import com.mycom.graph.*;

/**
 * Created by Admin on 10/17/2015.
 */
public class MathApp {
   public static void main(String[] args){

       Graph testGraph = new Graph();
       testGraph.addEdge("Home","Work");
       testGraph.addEdge("Home","Club");
       testGraph.debugPrint();
    }
}
