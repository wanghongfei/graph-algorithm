package cn.fh.ds.graph;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by wanghongfei on 15-3-14.
 */
public class test {
    String[] vertex = {"North Gate", "South Gate", "Classroom", "Square", "Toilet", "Canteen"};
    Edge[] edges = {
            new Edge("North Gate", "Classroom"),
            new Edge("North Gate", "Square"),
            new Edge("Classroom", "Toilet"),
            new Edge("Square", "Toilet"),
            new Edge("Square", "Canteen"),
            new Edge("Toilet", "South Gate"),
            new Edge("Toilet", "South Gate"),
    };

    @Test
    public void testBFS() {
        Graph g = new Graph(6, 7, new BroadFristSearchAlgorithm());
        addVertex(g);
        addEdge(g);
        g.done();

        Stack<String> result = g.findPathTo("Canteen");
        System.out.println("BFS: From [North Gate] to [Canteen]:");
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }


        result.empty();
        result = g.findPathTo("Toilet");
        System.out.println("BFS: From [North Gate] to [Toilet]:");
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }


        result.empty();
        result = g.findPathTo("South Gate");
        System.out.println("BFS: From [North Gate] to [South Gate]:");
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }

        result.empty();
        result = g.findPathTo("Square");
        System.out.println("BFS: From [North Gate] to [Square]:");
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }

    /**
     * DFS
     */
    @Test
    public void testDFS() {
        Graph g = new Graph(6, 7, new DeepFirstSearchAlgorithm());
        addVertex(g);
        addEdge(g);
        g.done();

        Stack<String> result = g.findPathTo("Canteen");
        System.out.println("From [North Gate] to [Canteen]:");
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }


        result.empty();
        result = g.findPathTo("Toilet");
        System.out.println("From [North Gate] to [Toilet]:");
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }


        result.empty();
        result = g.findPathTo("South Gate");
        System.out.println("From [North Gate] to [South Gate]:");
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }

        result.empty();
        result = g.findPathTo("Square");
        System.out.println("From [North Gate] to [Square]:");
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }

    private void addVertex(Graph g) {
        for (String v : vertex) {
            g.addVertex(v);
        }
    }
    private void addEdge(Graph g) {
        for (Edge e : edges) {
            g.addEdge(e.from, e.to);
        }
    }

    private class Edge {

        public String from;
        public String to;

        public Edge(String from, String to) {
            this.from = from;
            this.to = to;
        }
    }
}
