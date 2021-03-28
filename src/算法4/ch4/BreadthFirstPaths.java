package ch4;

import ch4.Graph;
import edu.princeton.cs.algs4.Queue;

/**
 * 广度优先搜索
 *
 * @ClassName BreadthFirstPaths
 * @Author weiliangchun
 * @Date 2020-01-06
 */
public class BreadthFirstPaths {
    private boolean[] marked;//到达该顶点的最短路径已知吗？
    private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点
    private final int s;//起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Queue<Integer> path = new Queue<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.enqueue(x);
        }
        path.enqueue(s);
        return path;
    }
}
