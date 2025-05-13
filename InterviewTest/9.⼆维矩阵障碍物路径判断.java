/*
 * 给定⼆维矩阵（0可⾛，1为障碍），判断能否从起点⾛到终点。
 * 输⼊：矩阵、起点坐标、终点坐标。
 * 输出：True/False。
 */

import java.util.LinkedList;
import java.util.Queue;

class Location {
    int x;
    int y;
    Location() {
        x = 0;
        y = 0;
    }
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solutions {
    public boolean canReach(int[][] matrix, Location start, Location end) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (start.x < 0 || start.x >= m || start.y < 0 || start.y >= n) {
            return false;
        }
        if (end.x < 0 || end.x >= m || end.y < 0 || end.y >= n) {
            return false;
        }
        if (matrix[start.x][start.y] == 1 || matrix[end.x][end.y] == 1) {
            return false;
        }
        if (start.x == end.x && start.y == end.y) {
            return true;
        }
        // 广度优先搜索
        Queue<Location> queue = new LinkedList<Location>();
        boolean[][] visited = new boolean[m][n];
        Location[] directions = new Location[] {
            new Location(-1, 0),
            new Location(1, 0),
            new Location(0, -1),
            new Location(0, 1)
        };

        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Location loc = queue.poll();
            if (loc.x == end.x && loc.y == end.y) {
                return true;
            }
            for (Location direction : directions) {
                int x = loc.x + direction.x;
                int y = loc.y + direction.y;
                if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == 0 && visited[x][y] == false) {
                    visited[x][y] = true;
                    Location next = new Location();
                    next.x = x;
                    next.y = y;
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}