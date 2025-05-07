/*
矩阵正交性验证
• 原题还原：
a. 给定⼀个 m x n 的矩阵 matrix ，判断其是否满⾜以下条件：
▪ 列向量两两正交（任意两列的内积为 0）。
▪ 列向量均为单位向量（每列的 L2 范数为 1）。
b. 若满⾜条件，返回 true ；否则返回 false 。
• 难度：Medium（需掌握线性代数基础，如向量内积、范数计算，并处理边界条件）。
*/
public static boolean isOrthogonalMatrix(double[][] matrix) {
    int m = matrix.length;
    if (m < 1) {
        return false;
    }
    int n = matrix[0].length;
    if (n < 1) {
        return false;
    }
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            double innerProduct = 0;
            for (int k = 0; k < m; k++) {
                innerProduct += matrix[k][i] * matrix[k][j];
            }
            if (i == j) {
                if (Math.abs(innerProduct - 1) > 1e-6) {
                    return false;
                }
            } else {
                if (Math.abs(innerProduct) > 1e-6) {
                    return false;
                }
            }
        }
    }
    return true;
}

public static void main(String[] args) {
    double[][] inMatrix = {
        {
            1, 1
        },
        {
            2, 2
        }
    };
    isOrthogonalMatrix(inMatrix);
}