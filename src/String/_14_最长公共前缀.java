package String;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//        如果不存在公共前缀，返回空字符串 ""。
//
//         
//
//        示例 1：
//
//        输入：strs = ["flower","flow","flight"]
//        输出："fl"
//        示例 2：
//
//        输入：strs = ["dog","racecar","car"]
//        输出：""
//        解释：输入不存在公共前缀。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/longest-common-prefix
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _14_最长公共前缀 {
    // https://leetcode.cn/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
    // 横向向扫描
    // 其实就是两个字符串求出公共前缀，再把公共前缀跟第三个字符串求公共前缀
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix,strs[i]);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0,index);
    }

    // https://leetcode.cn/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
    // 纵向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int count = strs.length;
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || temp != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        _14_最长公共前缀 a = new _14_最长公共前缀();
        String ans = a.longestCommonPrefix("abc","abc");
        System.out.println(ans);
    }

}
