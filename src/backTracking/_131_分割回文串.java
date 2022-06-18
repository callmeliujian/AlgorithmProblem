package backTracking;

import java.util.*;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
//        回文串 是正着读和反着读都一样的字符串。
//
//         
//
//        示例 1：
//
//        输入：s = "aab"
//        输出：[["a","a","b"],["aa","b"]]
//        示例 2：
//
//        输入：s = "a"
//        输出：[["a"]]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/palindrome-partitioning
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _131_分割回文串 {

    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> item = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return ans;
    }

    private void backTracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s,startIndex,i)) {
                item.add(s.substring(startIndex,i+1));
            } else {
                continue;
            }
            backTracking(s,i + 1);
            item.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
