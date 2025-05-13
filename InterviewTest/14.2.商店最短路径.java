/*
 * 商店坐标在x轴上，从任意商店出发到⽬标点(x,y)，求最短路径（允许重复访问⼀次）。
 * 输⼊：⽬标坐标。
 * 输出：最短路径⻓度。
 * 难度：Medium（⼏何或BFS）。
 */
class Solution {
    public double findShortestPath(int x, int y, int[] shops) {
        double minDistance = Double.MAX_VALUE;
        for (int shopX : shops) {
            // 计算欧几里得距离
            double dx = shopX - x;
            double dy = y; // 商店在x轴上，y坐标为0
            double distance = Math.sqrt(dx * dx + dy * dy);
            if (distance < minDistance) {
                minDistance = distance;
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 示例输入：目标点(3,4)，商店坐标列表
        int[] shops = {1, 3, 2, 2, 4};
        System.out.println(sol.findShortestPath(3, 4, shops)); // 输出应为2.0（商店坐标为3时，距离为4.0？需验证）
    }
}