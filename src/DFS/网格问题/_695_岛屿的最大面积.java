package DFS.网格问题;

public class _695_岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                     int a = dfs(grid,i,j);
                     res = Math.max(a,res);
                }
            }
        }
        return res;
    }

    private int dfs (int[][] grid, int row, int col) {
        if (!inArea(grid,row,col)) {
            return 0;
        }
        if (grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        return 1 + dfs(grid, row - 1,col) + dfs(grid, row + 1, col) + dfs(grid, row, col - 1) + dfs(grid,row,col + 1);
    }

    private boolean inArea(int[][] grid, int row, int col) {
        return  row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

}
