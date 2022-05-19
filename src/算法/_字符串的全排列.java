package 算法;

import java.util.ArrayList;
import java.util.List;

public class _字符串的全排列 {

    public List<String> func1(String string) {
        char[] str = string.toCharArray();
        List<String> list = new ArrayList<>();
        process1(str,0,list);
        return list;
    }

    // str[0...i-1]已经做好决定
    // str[i...]都有机会来到 i 位置
    // i 终止位置，str 当前的样子就是一种结果，加入到 list 里面
    public void process1(char[] str, int index, List<String>list) {
        if (index == str.length) {
            list.add(String.valueOf(str));
            return;
        }
        // 如果i没有终止，i以后的元素都可以来到i位置
        for (int j = index; j < str.length; j++) {// j -> i后面所有字符都有机会
            swap(str,index,j);
            process1(str,index + 1,list);
            swap(str,index,j);
        }
    }
    // 字符串全排列无重复
    public List<String> func2(String string) {
        char[] str = string.toCharArray();
        List<String> list = new ArrayList<>();
        process2(str,0,list);
        return list;
    }
    public void process2(char[] str, int index, List<String>list) {
        if (index == str.length) {
            list.add(str.toString());
        }
        boolean[] visit = new boolean[26];
        for (int j = index; j < str.length; j++) {
            // 分支限界法
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str,index,j);
                process1(str,index+1,list);
                swap(str,index,j);
            }
        }
    }

    void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        _字符串的全排列 o = new _字符串的全排列();
        String s = "aabc";
        List<String> list = o.func2(s);
        System.out.println(list);
    }

}
