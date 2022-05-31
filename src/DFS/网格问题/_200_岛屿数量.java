package DFS.网格问题;

public class _200_岛屿数量 {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res ++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (!inArea(grid,i,j)) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid,i - 1,j);
        dfs(grid,i + 1,j);
        dfs(grid,i, j - 1);
        dfs(grid,i, j + 1);
    }

    private boolean inArea(char[][] grid, int i, int j) {
        return i >= 0 &&  i < grid.length && j >= 0 && j < grid[0].length;
    }

}
