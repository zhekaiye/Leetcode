/*
 * 服务⼈员需规划路线，最⼤化休息时间（类似旅⾏商问题）。
 * 输⼊：图或路径参数。
 * 输出：最优路线。
 */

import java.util.Arrays;

class Solution {
    public int maxRestTime(int[][] graph) {
        int size = graph.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = graph[i][j];
            }
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int maxTime = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    maxTime = Math.max(maxTime, dp[i][j]);
                }
            }
        }
        return maxTime;
    }
}

/*
 * 输入：图的邻接矩阵表示，节点代表服务点，边权代表路径成本（如时间或距离）。

输出：访问所有节点一次并返回起点的最短路径，从而间接最大化休息时间。

目标：找到总成本最小的路径，使服务人员完成所有任务后有更长的休息时间。

动态规划是解决小规模TSP的有效方法，时间复杂度为 
O
(
n
2
⋅
2
n
)
O(n 
2
 ⋅2 
n
 )，适用于 
n
≤
20
n≤20 的场景。其核心思想是通过状态压缩记录已访问的节点集合和当前位置。

状态定义：dp[mask][i] 表示：

mask：二进制掩码，记录已访问的节点集合（如 mask=1010 表示访问了第1和第3个节点）。

i：当前所在的节点。

值为从起点出发，经过 mask 中的节点并最终到达 i 的最小成本。

状态转移：

dp[mask][i]=min{j∈mask,j≠i}(dp[mask∖{i}][j]+cost(j,i))
即从所有未访问 i 的状态中，选择一条到 i 的最短路径。

初始化：dp[1 << i][i] = 0（从起点 i 出发的初始状态）。

结果：遍历所有节点作为终点，计算 dp[全1掩码][i] + cost(i, 起点) 的最小值。
 */
public static int tsp(int[][] graph) {
    int n = graph.length;
    int[][] dp = new int[1 << n][n];
    for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
    
    // 初始化：从任意起点出发的初始状态
    for (int i = 0; i < n; i++) {
        dp[1 << i][i] = 0;
    }
    
    // 动态规划填表
    for (int mask = 1; mask < (1 << n); mask++) {
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) continue;
            for (int j = 0; j < n; j++) {
                if (i != j && (mask & (1 << j)) != 0) {
                    dp[mask][i] = Math.min(dp[mask][i], 
                        dp[mask ^ (1 << i)][j] + graph[j][i]);
                }
            }
        }
    }
    
    // 计算最终结果（需返回起点）
    int minCost = Integer.MAX_VALUE;
    int fullMask = (1 << n) - 1;
    for (int i = 0; i < n; i++) {
        minCost = Math.min(minCost, dp[fullMask][i] + graph[i][0]);
    }
    return minCost;
}