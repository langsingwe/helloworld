package ch4;

/**
 * 拓扑排序
 *
 * @ClassName Topological
 * @Author weiliangchun
 * @Date 2020-01-07
 */
public class Topological {
    private Iterable<Integer> order;//顶点的拓扑排序

    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
