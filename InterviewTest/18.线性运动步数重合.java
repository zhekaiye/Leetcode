/*
 * Martin的⽗亲从距离家X1⽶的位置开始，以恒定速度V1⽶/步直线跑步，共跑N步。Martin
从距离家X2⽶的位置出发，以恒定速度V2⽶/步跑步。Martin的第⼀步必须踩到⽗亲已经踩
过的某⼀步。请计算Martin应选择什么速度V2，才能最⼤化他与⽗亲的脚步重合次数F。如
果有多个V2使F相同，选择最⼤的V2。
◦ 难度：Medium（运动模型、数学⽅程，并能够通过遍历或优化算法）。
 */
class Solution {
    // public int calculateMaxOverlap(int x1, int v1, int n, int x2) {
    //     int maxOverlap = 0;
    //     int maxV2 = 0;
    //     for (int v2 = 1; v2 <= 100; v2++) {
    //         int overlap = calculateOverlap(x1, v1, n, x2, v2);
    //         if (overlap > maxOverlap) {
    //             maxOverlap = overlap;
    //             maxV2 = v2;
    //         } else if (overlap == maxOverlap && v2 > maxV2) {
    //             maxV2 = v2;
    //         }
    //     }
    //     return maxV2;
    // }

    // private int calculateOverlap(int x1, int v1, int n, int x2, int v2) {
    //     int overlap = 0;
    //     for (int i = 0; i < n; i++) {
    //         int position1 = x1 + i * v1;
    //         int position2 = x2 + i * v2;
    //         if (position1 == position2) {
    //             overlap++;
    //         }
    //     }
    //     return overlap;
    // }

    public int findBestV2(int X1, int V1, int N, int X2) {
        int maxF = 0;
        int bestV2 = -1;

        for (int k = 1; k <= N; k++) {
            int V2 = X1 + k * V1 - X2;
            if (V2 <= 0) continue; // 排除非正速度

            int d = gcd(V2, V1);
            int a = V2 / d;
            int tMax = (N - k) / a; // 整数除法自动向下取整
            int F = tMax + 1; // 解的数量为 tMax + 1

            // 更新最大F及对应的V2
            if (F > maxF) {
                maxF = F;
                bestV2 = V2;
            } else if (F == maxF && V2 > bestV2) {
                bestV2 = V2;
            }
        }

        return bestV2;
    }

    // 计算最大公约数
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}