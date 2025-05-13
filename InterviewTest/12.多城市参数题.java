/*
 * 经典多城市问题，涉及参数如距离、成本、连通性等，需优化路径或资源分配。
 * 输⼊：城市参数矩阵。
 * 输出：最优解（如最短路径、最⼩成本）。
 * 难度：Medium-Hard（图论或动态规划）。
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int findMinCost(int[][] graph) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // 假设起点为0
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            if (d > dist[u]) continue;
            
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 0) continue; // 假设0表示无连接
                int newDist = d + graph[u][v];
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{v, newDist});
                }
            }
        }
        
        // 示例输出：起点到终点的最短路径（终点为n-1）
        return dist[n-1] == Integer.MAX_VALUE ? -1 : dist[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        sc.close();
        Solution sol = new Solution();
        System.out.println(sol.findMinCost(graph));
    }
}