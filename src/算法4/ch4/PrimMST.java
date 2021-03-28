package ch4;

import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * 最小生成树的Prim算法
 *
 * @ClassName PrimMST
 * @Author weiliangchun
 * @Date 2020-01-08
 */
public class PrimMST {
    private Edge[] edgeTo;//距离树最近的边
    private double[] distTo;//distTo[w] = edgeTo[w].weight()
    private boolean[] marked;//如果v在树种则为true
    private IndexMinPQ<Double> pq;//有效地横切边

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        //将顶点v添加到树种，更新数据
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                continue;
            }
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (!pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }
}
