package ch1;

/**
 * union-find算法
 *
 * @ClassName UF
 * created by weilc on 2019/12/20 10:17
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean conncted(int p, int q) {
        return find(p) == find(q);
    }

    //quick-find的算法，find很快，union如果数据太大，很慢

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    //quick-union算法

    public int find2(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union2(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

}
