/*
 * 给定 n 个城市（编号从 0 到 n-1 ）和⼀组城市之间的连接关系 connections （每个
connections[i] = [a, b] 表⽰城市 a 和 b 直接相连）。
 * 定义「联通」：若城市 A 和 B 直接或间接相连，则属于同⼀联通区域。
 * 要求计算当前总共有多少个独⽴的联通区域。
 */
class UF {
    private int[] id;
    private int count;

    public UF(int num) {
        count = num;
        id = new int[num];
        for (int i = 0; i < num; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length <= 0) {
            return 0;
        }
        int size = isConnected.length;
        UF unionFind = new UF(size);
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (isConnected[i][j] > 0) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count();
    }
}


