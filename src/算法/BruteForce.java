package 算法;

import java.lang.reflect.Array;

// bf 算法
public class BruteForce {
    // str1 源串
    // str2 匹配串
    // beginIndex 开始匹配的位置
    // 匹配成功返回字符串的起始位置，匹配失败返回 -1
    public int bf(String str1, String str2, int beginIndex) {
        if (str1 == null || str2 == null) return -1;
        if (str1.length() == 0 || str2.length() == 0) return -1;
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        int i = beginIndex;
        int j = 0;
        while (i < str1Array.length && j < str2Array.length) {
            if (str1Array[i] == str2Array[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == str2Array.length) {
            // 匹配成功
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        String str1 = "abcacabdc";
        String str2 = "aca";
        BruteForce b = new BruteForce();
        int index = b.bf(str1,str2,0);
        System.out.print(index);
    }

}
