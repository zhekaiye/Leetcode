/*
 * 给定⼀个由 '1'（陆地）和 '0'（⽔）组成的⼆维⽹格，计算岛屿的数量。岛屿由⽔平或垂直
 * 相邻的 '1' 组成，假设⽹格四周被⽔包围。
 */
public int solve (char[][] grid) {
    // write code here
    if (grid.length <= 0) {
        return 0;
    }
    int result = 0;
    int row = grid.length;
    int column = grid[0].length;
    boolean[][] flagMatrix = new boolean[row][column];
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < column; j++) {
            if (grid[i][j] == '1' && !flagMatrix[i][j]) {
                result++;
                dfsVisitMap(grid, flagMatrix, i, j);
            }
        }
    }
    return result;
}

public void dfsVisitMap(char[][] grid, boolean[][] flag, int iPos, int jPos) {
    int row = grid.length;
    int column = grid[0].length;
    flag[iPos][jPos] = true;
    if (iPos > 0 && grid[iPos - 1][jPos] == '1' && !flag[iPos - 1][jPos]) {
        dfsVisitMap(grid, flag, iPos - 1, jPos);
    }
    if (iPos < row - 1 && grid[iPos + 1][jPos] == '1' && !flag[iPos + 1][jPos]) {
        dfsVisitMap(grid, flag, iPos + 1, jPos);
    }
    if (jPos > 0 && grid[iPos][jPos - 1] == '1' && !flag[iPos][jPos - 1]) {
        dfsVisitMap(grid, flag, iPos, jPos - 1);
    }
    if (jPos < column - 1 && grid[iPos][jPos + 1] == '1' && !flag[iPos][jPos + 1]) {
        dfsVisitMap(grid, flag, iPos, jPos + 1);
    }
}

public static void main(String[] args) {
    
}