/*
 * A student must solve an entire workbook of problems related to finding the area of intersection of twocircles. Because the problems are all very similar, the student decides to write a program that can solve allthese similar problems.
Input
The first line of the input consists of an integer centerX, representing the x coordinates of the center of the
first circle..
The second line consists of an integer centerY, representing the y coordinates of the center of the firstcircle..
The third line consists of an integer radius,, representing the radius of the first circleThe fourth line consists of an integer centerX, representing the x coordinates of the center of the secondcircle.
The fifth line consists of an integer centerY, representing the y coordinates of the center of the secondcircle.
The last line consists of an integer radiusz, representing the radius of the second circle.
Output
Print a real number representing the area of intersection of two circles rounded up to 6 decimal places
constraints
0<radius,, radius,<104

Example
Input:
0
0
2
3
0
2
 */

import java.util.Scanner;

class Solution {
    public double calculateCircleIntersectionArea(double x1, double y1, double r1, double x2, double y2, double r2) {
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return Math.PI * r1 * r1;
        }
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        if (distance >= r1 + r2) {
            return 0;
        }
        if (distance <= Math.abs(r1 - r2)) {
            return Math.PI * Math.min(r1, r2) * Math.min(r1, r2);
        }
        double p = (r1 + r2 + distance) / 2;
        double triangleArea = Math.sqrt(p * (p - r1) * (p - r2) * (p - distance));
        double h = triangleArea * 2 / distance;
        double angle1 = Math.asin(h / r1) * 2;
        double angle2 = Math.asin(h / r2) * 2;
        return r1 * r1 * angle1 / 2 + r2 * r2 * angle2 / 2 - triangleArea * 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double r1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double r2 = sc.nextDouble();
        sc.close();

        Solution solution = new Solution();
        double area = solution.calculateCircleIntersectionArea(0, 0, 2, 3, 0, 2);
        System.out.println(area);
    }
}