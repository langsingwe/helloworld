package ch4;

import edu.princeton.cs.algs4.Bag;

/**
 * 加权无向图的数据类型
 *
 * @ClassName EdgeWeightedGraph
 * @Author weiliangchun
 * @Date 2020-01-07
 */
public class EdgeWeightedGraph {
    private final int V;//顶点总数
    private int E;//边的总数
    private Bag<Edge>[] adj;//邻近表

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
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

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }


}
