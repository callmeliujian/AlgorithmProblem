package DFS.网格问题;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
//        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//         
//
//        示例 1：
//
//
//        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//        输出：true
//        示例 2：
//
//
//        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//        输出：true
//        示例 3：
//
//
//        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//        输出：false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/word-search
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _79_单词搜索 {
    // https://leetcode.cn/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
    private static final int[][] DIRECTIONS = {{-1,0},{0,-1},{1,0},{0,1}};
    int row;
    int col;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        if (row == 0) return false;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i,j,0,word.length(),word.toCharArray(),new boolean[row][col],board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index, int length, char[] charArray, boolean[][] visited, char[][] board) {
        if (index == length - 1) return board[i][j] == charArray[length - 1];
        if (board[i][j] == charArray[index]) {
            visited[i][j] = true;
            for (int[] d : DIRECTIONS) {
                int newX = i + d[0];
                int newY = j + d[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, index + 1, length, charArray, visited, board)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

}
