/*
 * 从起点到终点路径上有多个补给站，初始能量为K，每段路径消耗⼀定能量。求最少需要设置的
补给站数量。
输⼊：路径能量消耗数组，初始能量K。
输出：最⼩补给站数。
 */
public int minRefuelStops(int[] costs, int K) {
    int currentSum = 0; // 当前累计消耗
    int count = 0;      // 补给次数

    for (int cost : costs) {
        // 若单段消耗超过K，无法到达
        if (cost > K) return -1;

        currentSum += cost;

        // 若累计消耗超过K，必须设置补给站
        if (currentSum > K) {
            count++;
            currentSum = cost; // 重置为当前段消耗（补充后从当前段重新开始）
        }
    }

    return count;
}