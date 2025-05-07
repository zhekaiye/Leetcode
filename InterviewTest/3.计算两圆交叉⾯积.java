/*
计算两圆交叉⾯积
• 原题还原：
a. 给定两个圆的圆⼼坐标 (x1, y1) 和 (x2, y2) ，以及半径 r1 和 r2 ，计算两圆重叠
区域的⾯积。
b. 若两圆⽆重叠，返回 0 ；若完全重叠（同⼼且半径相同），返回圆的⾯积。
• 难度：Medium（需掌握⼏何数学公式，并处理浮点数精度问题）。
 */
public static double calculateCircleIntersectionArea(double x1, double y1, double r1, double x2, double y2, double r2) {
    if (x1 == x2 && y1 == y2 && r1 == r2) {
        return Math.PI * r1 * r1;
    }
    double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    if (distance > r1 + r2/* || distance < Math.abs(r1 - r2) */) {
        return 0;
    }
    if (distance <= Math.abs(r1 - r2)) {
        if (r1 < r2) {
            return Math.PI * r1 * r1;
        } else {
            return Math.PI * r2 * r2;
        }
    }
    double p = (r1 + r2 + distance) / 2;
    double triangleArea = Math.sqrt(p * (p - r1) * (p - r2) * (p - distance));
    double h = triangleArea * 2 / distance;
    double angle1 = Math.asin(h / r1) * 2;
    double angle2 = Math.asin(h / r2) * 2;

    return r1 * r1 * angle1 / 2 + r2 * r2 * angle2 / 2 - triangleArea * 2;
}

public static void main(String[] args) {
    calculateCircleIntersectionArea(1, 2, 3, 4, 5, 6);
}