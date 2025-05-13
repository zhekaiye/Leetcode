/*
 * 多叉树层序遍历，找到总和最⼩的层。
 * 输⼊：多叉树根节点。
 * 输出：最⼩层编号。
 * 难度：Easy（BFS）。
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    List<Node> children;
}

class Solution {
    public int findMinLevel(Node root) {
        if (root == null) return 0;

        int minLevel = 0;
        int minLevelSum = Integer.MAX_VALUE;
        int curLevel = 0;
        int curLevelSum = 0;

        Queue<Node> queue = new LinkedList<Node>();
        while (!queue.isEmpty()) {
            curLevel++;
            curLevelSum = 0;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                curLevelSum += node.val;
                queue.addAll(node.children);
            }
            if (curLevelSum < minLevelSum) {
                minLevelSum = curLevelSum;
                minLevel = curLevel;
            }
        }
        return minLevel;
    }
}