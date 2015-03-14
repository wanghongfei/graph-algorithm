package cn.fh.ds.graph;

import java.util.*;

/**
 * Created by wanghongfei on 15-3-15.
 */
public class BroadFristSearchAlgorithm implements Algorithm {
    private List<String> visitedVertex;
    private Map<String, String> path;


    @Override
    public void perform(Graph g, String sourceVertex) {
        if (null == visitedVertex) {
            visitedVertex = new ArrayList<>();
        }
        if (null == path) {
            path = new HashMap<>();
        }

        BFS(g, sourceVertex);
    }

    @Override
    public Map<String, String> getPath() {
        return path;
    }

    private void BFS(Graph g, String sourceVertex) {
        Queue<String> queue = new LinkedList<>();
        // 标记起点
        visitedVertex.add(sourceVertex);
        queue.add(sourceVertex);

        while (false == queue.isEmpty()) {
            String ver = queue.poll();

            List<String> toBeVisitedVertex = g.getAdj().get(ver);
            for (String v : toBeVisitedVertex) {
                if (false == visitedVertex.contains(v)) {
                    visitedVertex.add(v);
                    path.put(v, ver);
                    queue.add(v);
                }
            }
        }
    }
}
