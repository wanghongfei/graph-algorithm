package cn.fh.ds.graph;

import java.util.Map;

/**
 * Created by wanghongfei on 15-3-14.
 */
public interface Algorithm {
    void perform(Graph g, String sourceVertex);
    Map<String, String> getPath();
}
