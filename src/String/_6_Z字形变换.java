package String;

import java.util.*;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
//        比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//        P   A   H   N
//        A P L S I I G
//        Y   I   R
//        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
//        请你实现这个将字符串进行指定行数变换的函数：
//
//        string convert(string s, int numRows);
//         
//
//        示例 1：
//
//        输入：s = "PAYPALISHIRING", numRows = 3
//        输出："PAHNAPLSIIGYIR"
//        示例 2：
//        输入：s = "PAYPALISHIRING", numRows = 4
//        输出："PINALSIGYAHRPI"
//        解释：
//        P     I    N
//        A   L S  I G
//        Y A   H R
//        P     I
//        示例 3：
//
//        输入：s = "A", numRows = 1
//        输出："A"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/zigzag-conversion
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _6_Z字形变换 {

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int index = 0; int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rows.get(index).append(c);
            if (index == 0 ||index == numRows - 1) flag = -flag;
            index += flag;
        }
        StringBuilder finalBuilder = new StringBuilder();
        for (StringBuilder row : rows) {
            finalBuilder.append(row);
        }
        return finalBuilder.toString();
    }

}
