package cn.fh.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghongfei on 15-3-14.
 */
public class DeepFirstSearchAlgorithm implements Algorithm {
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

        DFS(g, sourceVertex);

    }

    @Override
    public Map<String, String> getPath() {
        return path;
    }

    private void DFS(Graph g, String vertex) {
        // 标记顶点已访问
        visitedVertex.add(vertex);

        // 访问与本顶点相连的点
        List<String> toBeVisitedVertex = g.getAdj().get(vertex);
        for (String ver : toBeVisitedVertex) {
            if (false == visitedVertex.contains(ver)) {
                // 记录路径
                // 从vertex 到 ver
                path.put(ver, vertex);

                DFS(g, ver);
            }
        }
    }


}
