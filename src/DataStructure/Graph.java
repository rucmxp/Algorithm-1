package DataStructure;

/**
 * Created by Lunar on 2016/1/24.
 * 图
 */
public class Graph {
    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;

        adj = (Bag<Integer>[]) new Bag[V];//创建邻接表
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }

    }

    //计算v的度数
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    //计算所有顶点的最大度数
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }

        }
        return max;
    }

    //计算所有顶点平均度数
    public static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    //计算自环的个数:结点自己指向自己
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);//将w添加到v的链表中
        adj[w].add(v);//将v添加到w的链表中
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    //图的邻接表的字符串表示（Graph 的实例方法
    public String toString() {
        String s = V + "vertices, " + E + "edges\n";

        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
