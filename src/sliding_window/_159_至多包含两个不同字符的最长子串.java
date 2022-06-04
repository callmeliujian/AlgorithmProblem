package sliding_window;

import java.util.HashMap;

public class _159_至多包含两个不同字符的最长子串 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max_len = 0;
        int start = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if (map.containsKey(currentChar)) {
                map.put(currentChar,map.get(currentChar) + 1);
            } else {
                map.put(currentChar,1);
            }
            if (map.size() <= 2) {
                max_len = Math.max(max_len, i - start + 1);
            }
            while (map.size() > 2) {
                char head = charArray[start];
                int value = map.get(head) - 1;
                if (value == 0) {
                    map.remove(head);
                } else  {
                    map.put(head,value);
                }
                start++;
            }
        }
        return max_len;
    }

}
