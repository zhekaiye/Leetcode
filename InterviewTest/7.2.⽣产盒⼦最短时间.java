/*
 * ⽣产盒⼦可以选择购买或制造机器，制造机器需要时间但后续⽣产更快。求⽣产⽬标数量的最短时间。
 * 输⼊：⽣产需求参数。
 * 输出：最短时间。
 */

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();    // 目标生产数量
        int B = sc.nextInt();    // 单台购买时间
        int M = sc.nextInt();    // 单台制造时间
        int R = sc.nextInt();    // 单台生产率
        sc.close();
        
        // 直接使用初始机器的时间
        double directTime = (double) N / R;
        
        // 计算购买机器的最优时间
        double buyTime = findOptimalTime(N, B, R);
        
        // 计算制造机器的最优时间
        double buildTime = findOptimalTime(N, M, R);
        
        // 取三者最小值
        double minTime = Math.min(directTime, Math.min(buyTime, buildTime));
        System.out.printf("%.6f", minTime);
    }

    // 通用计算最优时间的函数（cost为单台成本）
    private static double findOptimalTime(int N, int cost, int rate) {
        if (cost <= 0 || N <= 0) return Double.MAX_VALUE;
        
        // 理论最优解（可能为小数）
        double mOptimal = Math.sqrt((double) N / (cost * rate)) - 1;
        int[] candidates = {
            (int) Math.floor(mOptimal),
            (int) Math.ceil(mOptimal),
            (int) Math.floor(mOptimal) - 1,
            (int) Math.ceil(mOptimal) + 1,
            0  // 必须检查m=0的情况
        };
        
        double minTime = Double.MAX_VALUE;
        for (int m : candidates) {
            if (m < 0) continue; // 跳过无效值
            int totalMachines = m + 1;
            double time = m * cost + (double) N / (totalMachines * rate);
            if (time < minTime) {
                minTime = time;
            }
        }
        return minTime;
    }
}