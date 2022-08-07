package sliding_window;
import java.util.*;

public class _76_最小覆盖子串 {

    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character,Integer> needMap = new HashMap<>();
            HashMap<Character,Integer> windowMap = new HashMap<>();
            char[] tArray = t.toCharArray();
            char[] sArray = s.toCharArray();
            for (char item : tArray) {
                needMap.put(item, needMap.getOrDefault(item, 0) + 1);
            }

            int left = 0, right = 0, length = Integer.MAX_VALUE, start = 0;
            int vaild = 0;
            while (right < sArray.length) {
                char rightItem = sArray[right];
                right++;
                if (needMap.containsKey(rightItem)) {
                    windowMap.put(rightItem, windowMap.getOrDefault(rightItem, 0) + 1);
                    if (windowMap.get(rightItem).equals(needMap.get(rightItem))) {
                        vaild++;
                    }
                }

                while (vaild == needMap.size()) {
                    if (right - left < length) {
                        start = left;
                        length = right - left;
                    }
                    char leftItem = sArray[left];
                    left++;
                    if (needMap.containsKey(leftItem)) {
                        int windowValue = windowMap.get(leftItem);
                        int needValue = needMap.get(leftItem);
                        if (windowValue == needValue) {
                            vaild--;
                        }
                        windowMap.put(leftItem, windowValue - 1);
                    }
                }

            }
            if (length == Integer.MAX_VALUE) {
                return "";
            } else {
                return s.substring(start, start + length);
            }

        }
    }


    // 减法思路
    public String minWindow1(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if (sLength == 0 || tLength == 0 || sLength < tLength) {
            return "";
        }

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        // ascii('z') = 122
        // 使用字符词频数组
        // int[] winFreq = new int[123]; 也行，但是习惯上写成 2的方幂
        // freq 频率
        // 窗口内部覆盖 T 还需要的各个字符的个数
        int[] tFreq = new int[128];
        for (char c : tCharArray) {
            tFreq[c]++;
        }

        // 滑动窗口内部还差多少 T 中的字符，对应字符频数超过不重复计算
        // distance 编辑距离
        int distance = tLength;
        int minLength = sLength + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        // [left,right)
        while (right < sLength) {
            if (tFreq[sCharArray[right]] > 0) {
                distance--;
            }
            // 窗口里面的词频超过 t 的词频没有问题，因为通过 distance 判断的
            tFreq[sCharArray[right]]--;
            right++;

            // 调整左面的值 left
            while (distance == 0) {
                if (right - left < minLength) { // 调整最小值
                    minLength = right - left;
                    begin = left;
                }
                if (tFreq[sCharArray[left]] == 0) {
                    distance++;
                }
                tFreq[sCharArray[left]]++;
                left++;
            }
        }
        if (minLength == sLength + 1) {
            return "";
        }
        return s.substring(begin,begin + minLength);
    }

    // 加分思路
    public String minWindow(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if (sLength == 0 || tLength == 0 || sLength < tLength) {
            return "";
        }

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        // ascii('z') = 122
        // 使用字符词频数组
        // int[] winFreq = new int[123]; 也行，但是习惯上写成 2的方幂
        // freq 频率
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (char c : tCharArray) {
            tFreq[c]++;
        }

        // 滑动窗口内部包含多少 T 中的字符，对应字符频数超过不重复计算
        // distance 编辑距离
        int distance = 0;
        int minLength = sLength + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        // [left,right)
        while (right < sLength) {
            // s的某个位置的字符串不在t里面出现
            if (tFreq[sCharArray[right]] == 0) {
                right++;
                continue;
            }

            if (winFreq[sCharArray[right]] < tFreq[sCharArray[right]]) {
                distance++;
            }
            // 窗口里面的词频超过 t 的词频没有问题，因为通过 distance 判断的
            winFreq[sCharArray[right]]++;
            right++;

            // 调整左面的值 left
            while (distance == tLength) {
                if (right - left < minLength) { // 调整最小值
                    minLength = right - left;
                    begin = left;
                }
                if (tFreq[sCharArray[left]] == 0) { // s某个字符不存在 t里面则left++
                    left++;
                    continue;
                }
                if (winFreq[sCharArray[left]] == tFreq[sCharArray[left]]) {
                    distance--;
                }
                winFreq[sCharArray[left]]--;
                left++;
            }
        }
        if (minLength == sLength + 1) {
            return "";
        }
        return s.substring(begin,begin + minLength);
    }

}
