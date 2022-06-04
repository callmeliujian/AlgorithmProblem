package sliding_window;

import java.util.HashMap;

public class _3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int max_len = 0;
        char[] charArray = s.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int start = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.containsKey(charArray[i])) {
                hashMap.put(charArray[i],hashMap.get(charArray[i]) + 1);
            } else {
                hashMap.put(charArray[i], 1);
            }
            if (hashMap.size() == i - start + 1) {
                max_len = Math.max(max_len, i - start + 1);
            }
            while (i - start + 1 > hashMap.size()) {
                char head = charArray[start];
                int value = hashMap.get(head) - 1;
                if (value == 0) {
                    hashMap.remove(head);
                } else {
                    hashMap.put(head,value);
                }
                start++;
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        _3_无重复字符的最长子串 ob = new _3_无重复字符的最长子串();
        String str = "eeydgwdykpv";
        int length = ob.lengthOfLongestSubstring(str);
        System.out.println(length);
    }

}
