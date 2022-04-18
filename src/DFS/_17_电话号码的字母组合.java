package DFS;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//         
//
//        示例 1：
//
//        输入：digits = "23"
//        输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        示例 2：
//
//        输入：digits = ""
//        输出：[]
//        示例 3：
//
//        输入：digits = "2"
//       输出：["a","b","c"]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class _17_电话号码的字母组合 {

    private char[] chars;
    private List<String> list;
    /** 用来存储每一层选择的字母 */
    private char[] string;

    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }
        list = new ArrayList<>();
        chars = digits.toCharArray();
        if (chars.length == 0) {
            return list;
        }
        string = new char[chars.length];
        dfs(0);
        return list;
    }

    /**
     * @param idx 正在搜索第idx层
     */
    private void dfs(int idx) {
        // 已经进入到最后一层了，不能再往下搜索
        if (idx == chars.length) {
            // 得到了一个正确的解
            list.add(new String(string));
            return;
        }
        // 先枚举这一层可以做的所有选择
        char [] lettrs = lettersArray[chars[idx] - '2'];
        for (char letter : lettrs) {
            string[idx] = letter;
            dfs(idx + 1);
        }
    }

}
