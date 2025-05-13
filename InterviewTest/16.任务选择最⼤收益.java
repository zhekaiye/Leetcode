/*
 * 每天可选做困难任务（⾼收益，但有条件限制）、简单任务或休息。求n天的最⼤收益。
 * 输⼊：每天的任务收益数组。
 * 输出：最⼤收益。
 * 难度：Hard（动态规划，状态转移需考虑前⼀天是否休息）。
 */
class Solution {
    public int maxProfit(int[][] tasks) {
        int n = tasks.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = 0;                   // 第0天休息
        dp[0][1] = tasks[0][0];          // 第0天做困难任务
        dp[0][2] = tasks[0][1];          // 第0天做简单任务
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + tasks[i][0];
            dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + tasks[i][1];
        }
        
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }
}