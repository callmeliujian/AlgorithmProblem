package 动态规划;

// 时间复杂度 n 的 n 次方。优化只能进行常数优化。

public class _N皇后 {

    public int totalNQueens(int n) {
        int res = 0;
        int[] record = new int[n];
        res = process1(0, record, n);
        return res;
    }

    //潜台词：record[0...i - 1]的皇后，任何两个皇后一定都不共行、不共列、不共斜线
    //目前来到了第 i 行
    //record[0...i - 1]表示之前的行放了皇后的位置，数组的index 代表行，数组的index里面的value代表列
    //n 代表整体一共有多少行 0～n-1 行
    //返回值是，摆完所有的皇后，合理的摆法有多少种
    private int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        // 没有到终止的位置，还有皇后要摆
        int res = 0;
        for (int j = 0; j < n; j++) { // 当前在 i 行，尝试 i 行所有的列 -> j
            // 当前 i 行的皇后，放在 j 列，会不会和之前 (0..i-1) 的皇后共行、共列、共斜线?
            // 如果 isValid 返回 true 则不共行、不共列、不共斜线
            // 如果 isValid 返回 false 则共行、共列、共斜线
            if (isValid(record,i,j)) {
                record[i] = j;
                res += process1(i + 1,record,n);
            }
        }
        return res;
    }

    // i 行 j 列
    // 肯定不同行
    // 判断标准：不能同列，不能同斜线。
    // a 行 b 列，c 行 d 列 如何判断？
    // b == d || |a-c| == |b-d| 同列或者同斜线
    private boolean isValid(int[] record, int i, int j) {
        // 肯定不同行
        for(int k = 0; k < i; k++) {
            // i 行 j 列   k 行，record[k]列
            if (j == record[k] || Math.abs(i - k) == Math.abs(j - record[k])) {
                return false;
            }
        }
        return true;
    }

    public int totalNQueens1(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        // 如果你是 13 皇后问题， limit 最右 13 个1，其他都是 0
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    // limit 划定了问题的规模 -> 固定
    // colLim 列的限制，1 的位置不能放皇后，0 的位置可以。
    // leftDiaLim 左斜线限制，1 的位置不能放皇后，0 的位置可以。
    // rightDiaLim 右斜线限制，1 的位置不能放皇后，0 的位置可以。
    private int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        // 所有可以放皇后的位置，都在 pos 上
        // colLim ｜ leftDiaLim ｜ rightDiaLim -> 总限制
        // ~(colLim ｜ leftDiaLim ｜ rightDiaLim) -> 左侧的一坨 0 干扰，右侧每个 1，可以尝试
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            //取出 pos 中，最右侧的 1 来，剩下的都是 0
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res+=process2(limit,
                    colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        _N皇后 a = new _N皇后();
        int res = a.totalNQueens1(4);
        System.out.println(res);
    }

}
