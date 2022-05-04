package 面试题;

public class _767_重构字符串 {

    public String reorganizeString(String s) {
        char[] array = s.toCharArray();
        int n = array.length;

        int[] count = new int[26];
        for (char c : array) {
            count[c - 'a']++;
        }

        int maxIdx = 0;
        for (int i = 0; i < count.length;i++) {
            if (count[i] > maxIdx) {
                maxIdx = i;
            }
        }

        // (n+1) / 2 同时考虑了 奇数 和 偶数 情况
        if (count[maxIdx] > (n + 1) / 2) return "";

        // 先把出现次数最多的字符放在偶数位置上
        char[] res = new char[n];
        int i = 0;
        while (count[maxIdx]-- > 0) {
            res[i] = (char) ('a' + maxIdx);
            i += 2;
        }

        // 考虑其他的字符
        for (int j = 0; j < count.length; j++) {
            while (count[j]-- >0) {
                if (i >= n) i = 1;
                res[i] = (char)('a' + j);
                i += 2;
            }
        }
        return String.valueOf(res);
    }

}
