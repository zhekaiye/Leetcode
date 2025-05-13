/*
 * 邀请最多⼈数参加晚宴，但某些⼈互斥不能同时邀请。
 * 输⼊：互斥关系列表。
 * 输出：最⼤⼈数。
 *  Medium（图的最⼤独⽴集或回溯）。
 */

import java.util.Scanner;

class Solution {
    private int max = 0;
    
    public int maxInvitation(int n, int[][] dislikes) {
        boolean[][] graph = new boolean[n][n];
        for (int[] pair : dislikes) {
            int u = pair[0] - 1; // 转换为0-based索引
            int v = pair[1] - 1;
            graph[u][v] = true;
            graph[v][u] = true;
        }
        backtrack(0, new boolean[n], 0, graph);
        return max;
    }

    private void backtrack(int index, boolean[] selected, int count, boolean[][] graph) {
        if (index == graph.length) {
            max = Math.max(max, count);
            return;
        }
        // 不选当前节点
        backtrack(index + 1, selected, count, graph);
        // 选当前节点，需检查是否与已选节点互斥
        boolean canSelect = true;
        for (int i = 0; i < index; i++) {
            if (selected[i] && graph[index][i]) {
                canSelect = false;
                break;
            }
        }
        if (canSelect) {
            selected[index] = true;
            backtrack(index + 1, selected, count + 1, graph);
            selected[index] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dislikes = new int[m][2];
        for (int i = 0; i < m; i++) {
            dislikes[i][0] = sc.nextInt();
            dislikes[i][1] = sc.nextInt();
        }
        sc.close();
        Solution sol = new Solution();
        System.out.println(sol.maxInvitation(n, dislikes));
    }
}