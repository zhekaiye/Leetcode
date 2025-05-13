/*
 * CEO需坐在喜欢的CEO旁边才能参会，求最多参会⼈数。
 * 输⼊：CEO关系图。
 * 输出：最⼤参会⼈数。
◦ 难度：Hard（图的最⼤团或回溯）。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // public int findMaxAttendees(int[][] graph) {
    //     int n = graph.length;
    //     int maxAttendees = 0;
    //     for (int i = 0; i < n; i++) {
    //         int[] visited = new int[n];
    //         visited[i] = 1;
    //         int count = dfs(graph, visited, i, 1);
    //         maxAttendees = Math.max(maxAttendees, count);
    //     }
    //     return maxAttendees;
    // }
    // private int dfs(int[][] graph, int[] visited, int cur, int count) {
    //     int n = graph.length;
    //     int maxCount = count;
    //     for (int i = 0; i < n; i++) {
    //         if (graph[cur][i] == 1 && visited[i] == 0) {
    //             visited[i] = 1;
    //             maxCount = Math.max(maxCount, dfs(graph, visited, i, count + 1));
    //             visited[i] = 0;
    //         }
    //     }
    //     return maxCount;
    // }
    // public static void main(String[] args) {
    //     int[][] graph = {
    //         {0, 1, 1, 0},
    //         {1, 0, 1, 1},
    //         {1, 1, 0, 1},
    //         {0, 1, 1, 0}
    //     };
    //     Solution solution = new Solution();
    //     int maxAttendees = solution.findMaxAttendees(graph);
    //     System.out.println(maxAttendees);
    // }

    private int maxSize = 0;
    private boolean[][] graph;
    private int[] nodeOrder;

    public int maxParticipants(int[][] relations) {
        int n = relations.length;
        graph = new boolean[n][n];
        // 构建邻接矩阵
        for (int i = 0; i < n; i++) {
            for (int j : relations[i]) {
                graph[i][j] = true;
                graph[j][i] = true;
            }
        }
        // 按度数排序节点，优化搜索顺序
        nodeOrder = new int[n];
        Integer[] degrees = new Integer[n];
        for (int i = 0; i < n; i++) degrees[i] = i;
        Arrays.sort(degrees, (a, b) -> Integer.compare(countDegree(b), countDegree(a)));
        for (int i = 0; i < n; i++) nodeOrder[i] = degrees[i];

        backtrack(new ArrayList<>(), 0);
        return maxSize;
    }

    // 计算节点的度数
    private int countDegree(int node) {
        int cnt = 0;
        for (boolean connected : graph[node]) {
            if (connected) cnt++;
        }
        return cnt;
    }

    private void backtrack(List<Integer> currentClique, int start) {
        if (currentClique.size() > maxSize) {
            maxSize = currentClique.size();
        }
        // 剪枝：剩余节点数 + 当前团大小 <= 已找到的最大值时停止
        if (start >= nodeOrder.length || currentClique.size() + (nodeOrder.length - start) <= maxSize) {
            return;
        }
        for (int i = start; i < nodeOrder.length; i++) {
            int node = nodeOrder[i];
            if (canAddToClique(currentClique, node)) {
                currentClique.add(node);
                backtrack(currentClique, i + 1);
                currentClique.remove(currentClique.size() - 1);
            }
        }
    }

    // 检查新节点是否与当前团中所有节点相连
    private boolean canAddToClique(List<Integer> clique, int newNode) {
        for (int member : clique) {
            if (!graph[newNode][member]) {
                return false;
            }
        }
        return true;
    }
}