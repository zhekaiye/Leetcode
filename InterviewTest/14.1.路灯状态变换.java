/*
 * 路灯初始状态为0/1（关/开），每次变换规则：若左右灯状态相同则中间灯亮，否则灭。求
n次变换后的状态。
输⼊：初始状态数组，变换次数n；
输出：变换后状态数组；
难度：Medium（模拟或数学规律）
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] lightAfterNTimes(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        boolean hasCycle = false;
        int cycleLength = 0;
        int[] current = cells.clone();
        int remainingDays = n;
        
        while (remainingDays > 0) {
            String key = Arrays.toString(current);
            if (seen.containsKey(key)) {
                // 检测到循环周期
                hasCycle = true;
                int prevDay = seen.get(key);
                cycleLength = remainingDays - prevDay;
                remainingDays %= cycleLength;
                break;
            } else {
                seen.put(key, remainingDays);
            }
            
            current = getNextState(current);
            remainingDays--;
        }
        
        // 处理剩余天数（如果有循环）
        if (hasCycle) {
            for (int i = 0; i < remainingDays; i++) {
                current = getNextState(current);
            }
        }
        
        return current;
    }

    private int[] getNextState(int[] current) {
        int[] next = new int[current.length];
        next[0] = 0; // 首元素固定为0
        if (current.length > 1) {
            next[current.length - 1] = 0; // 尾元素固定为0
        }
        for (int i = 1; i < current.length - 1; i++) {
            next[i] = (current[i - 1] == current[i + 1]) ? 1 : 0;
        }
        return next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 示例测试
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int n = 7;
        int[] result = sol.lightAfterNTimes(cells, n);
        System.out.println(Arrays.toString(result)); // 输出应为 [0, 0, 1, 1, 0, 0, 1, 0]
    }
}