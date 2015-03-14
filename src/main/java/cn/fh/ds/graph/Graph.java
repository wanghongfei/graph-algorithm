package cn.fh.ds.graph;

import java.util.*;

/**
 * (无向)图
 */
public class Graph {
    private int vertexAmount;
    private int edgeAmount;

    private String firstVertax;

    // 邻接表
    private Map<String, List<String>> adj = new HashMap<>();

    private Algorithm algorithm;

    public Graph(int vertexAmount, int edgeAmount, Algorithm algorithm) {
        this.vertexAmount = vertexAmount;
        this.edgeAmount = edgeAmount;
        this.algorithm = algorithm;
    }

    public void done() {
        algorithm.perform(this, firstVertax);
    }

    public Stack<String> findPathTo(String vertex) {
        Stack<String> stack = new Stack<>();
        stack.add(vertex);

        Map<String, String> path = algorithm.getPath();
        for (String location = path.get(vertex) ; false == location.equals(firstVertax) ; location = path.get(location)) {
            stack.push(location);
        }
        stack.push(firstVertax);

        return stack;
    }

    /**
     * 添加一条边
     * @param fromVertex
     * @param toVertex
     */
    public void addEdge(String fromVertex, String toVertex) {
        if (firstVertax == null) {
            firstVertax = fromVertex;
        }

        adj.get(fromVertex).add(toVertex);
        adj.get(toVertex).add(fromVertex);
    }

    /**
     * 添加一个顶点
     * @param vertex
     */
    public void addVertex(String vertex) {
        adj.put(vertex, new ArrayList<>());
    }

    public Map<String, List<String>> getAdj() {
        return adj;
    }
}
