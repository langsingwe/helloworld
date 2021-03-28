package ch4;

import edu.princeton.cs.algs4.Bag;

/**
 * 加权有向图的数据类型
 *
 * @ClassName EdgeWeightedDigraph
 * @Author weiliangchun
 * @Date 2020-01-08
 */
public class EdgeWeightedDigraph {
    private final int V;//顶点总数
    private int E;//边的总数
    private Bag<DirectedEdge>[] adj;//邻近表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                bag.add(e);
            }
        }
        return bag;
    }
}
