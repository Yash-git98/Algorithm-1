package algs.unionfind.quick_union;

/**
 * 并查集基本实现
 * quick-union
 *
 * @author AlbertRui
 * @date 2018-03-28 21:01
 */
@SuppressWarnings("ALL")
public class UnionFind {

    //分量id（以触点作为索引）
    private int[] id;
    //分量数量l
    private int count;

    /**
     * 构造其中初始化分量id数组
     *
     * @param N
     */
    public UnionFind(int N) {
        this.count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 获取分量数量
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * 判断p和q是否存在于同一个分量中
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * p（0到N-1）所在的分量的标识符
     *
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 在p和q之间添加一条连接
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {

        //将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);

        //如果p和q已经在相同的分量之中则不需要采取任何行动
        if (pRoot == qRoot) {
            return;
        }

        //将p的分量名称重命名为q的分量名称
        id[pRoot] = qRoot;

        count--;

    }

}
