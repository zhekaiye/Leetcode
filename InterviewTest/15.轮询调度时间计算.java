/*
 * 给定任务列表和处理器数量，计算轮询调度完成所有任务的总时间。
输⼊：任务时⻓数组，处理器数。
输出：总时间。
◦ 难度：Medium（优先队列或贪⼼）。
 */

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int scheduleTasks(int[] tasks, int numProcessors) {
        Arrays.sort(tasks); // 对任务按时间升序排序

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < numProcessors; i++) {
            pq.offer(0); // 初始化每个处理器的当前时间为0
        }
        for (int i = tasks.length - 1; i >= 0; i--) {
            int minTime = pq.poll(); // 找到当前时间最小的处理器
            pq.offer(minTime + tasks[i]); // 将任务分配给该处理器
        }
        int maxTime = 0;
        while (!pq.isEmpty()) {
            maxTime = Math.max(maxTime, pq.poll()); // 找到所有处理器中最大的时间
        }
        return maxTime;
        // int[] processorTimes = new int[numProcessors]; // 每个处理器的当前时间  
        // for (int i = tasks.length - 1; i >= 0; i--) {
        //     int minTime = Arrays.stream(processorTimes).min().getAsInt(); // 找到当前时间最小的处理器
        //     processorTimes[minTime] += tasks[i]; // 将任务分配给该处理器        
        // }
        // return Arrays.stream(processorTimes).max().getAsInt(); // 返回所有处理器中最大的时间
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] tasks = {3, 1, 2, 4};
        int k = 2;
        System.out.println(sol.scheduleTasks(tasks, k)); // 输出：5
    }
}