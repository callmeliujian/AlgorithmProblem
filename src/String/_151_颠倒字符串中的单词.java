package String;

public class _151_颠倒字符串中的单词 {

    public String reverseWords(String s) {
        if (s == null)
            return "";
        char [] chars = s.toCharArray();
        // 1. 消除多余空格
        // 字符串最终的有效长度
        int len = 0;
        // 当前用来存放字符的位置
        int cur = 0;
        // 前一个字符是否为空格
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') { // chars[i]是非空格字符
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {
                chars[cur++] = ' ';
                space = true;
            }
        }
        len = space ? cur - 1 : cur;
        if (len <= 0) {
            return "";
        }
        // 2.对整一个有效字符串进行逆序,左闭右开
        reverse(chars, 0, len);
        // 3.对每一个单词进行逆序
        // 前一个空格字符的位置（有-1位置有个假象的哨兵，就是一个假象的空格字符）
        int prevSpaceIdx = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;
            reverse(chars,prevSpaceIdx + 1, i);
            prevSpaceIdx = i;
        }
        // 反转最后一个单词
        reverse(chars, prevSpaceIdx + 1, len);
        return new String(chars, 0, len);
    }

    private  void reverse(char[] chars, int li, int ri) {
        ri --;
        while (li < ri) {
            char tmp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = tmp;
            li ++;
            ri --;
        }
    }

}
