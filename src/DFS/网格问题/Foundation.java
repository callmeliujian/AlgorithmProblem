package DFS.网格问题;

public class Foundation {
    // grid 网格数组
    // r 行
    // c 列
    // 0 代表海洋格子； 1 代表陆地格子（未遍历过）；2 代表陆地格子（已遍历过）
    public void dfs(int[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid,r,c)) {
            return;
        }
        //如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        // 将格子标记为已经遍历过
        grid[r][c] = 2;
        // 访问上、下、左、右四个相邻节点
        dfs(grid,r - 1,c);
        dfs(grid,r + 1,c);
        dfs(grid,r,c - 1);
        dfs(grid,r,c + 1);
    }

    boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

}
