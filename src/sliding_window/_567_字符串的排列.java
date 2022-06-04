package sliding_window;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
//        换句话说，s1 的排列之一是 s2 的 子串 。
//
//         
//
//        示例 1：
//
//        输入：s1 = "ab" s2 = "eidbaooo"
//        输出：true
//        解释：s2 包含 s1 的排列之一 ("ba").
//        示例 2：
//
//        输入：s1= "ab" s2 = "eidboaoo"
//        输出：false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/permutation-in-string
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.HashMap;

public class _567_字符串的排列 {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> hashMap_s1 = new HashMap<>();
        HashMap<Character,Integer> hashMap_s2 = new HashMap<>();
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        for (int i = 0; i < s1CharArray.length; i++) {
            int value = hashMap_s1.getOrDefault(s1CharArray[i],0) + 1;
            hashMap_s1.put(s1CharArray[i],value);
        }
        int start = 0;
        for (int i = 0; i < s2CharArray.length; i ++) {
            char c = s2CharArray[i];
            int value = hashMap_s2.getOrDefault(c,0) + 1;
            hashMap_s2.put(c,value);
            if (hashMap_s2.equals(hashMap_s1)) {
                return true;
            }
            if (i >= s1CharArray.length - 1) {
                char head = s2CharArray[start];
                int headValue = hashMap_s2.get(head) - 1;
                if (headValue == 0) {
                    hashMap_s2.remove(head);
                } else {
                    hashMap_s2.put(head,headValue);
                }
                start++;
            }
        }
        return false;
    }

    public static  void main(String[] args) {
        _567_字符串的排列 ob = new _567_字符串的排列();
        String s = "ab";
        String p = "eidbaooo";
        boolean res = ob.checkInclusion(s,p);
        System.out.println(res);
    }

}
