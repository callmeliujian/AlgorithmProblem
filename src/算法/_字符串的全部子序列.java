package 算法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _字符串的全部子序列 {

    public List<String>subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str,0,ans,path);
        return ans;
    }
    // str 固定不变
    // index 此时来到的位置， 要 or 不要
    // 如果 index 来到了 str 中的终止位置，把沿途路径所形成的答案加入 ans 中
    // 之前做出的选择就是 path
    public void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process1(str,index + 1,ans,no);
        String yes = path + String.valueOf(str[index]);
        process1(str,index + 1,ans,yes);
    }
    // 不包含重复字符串
    public List<String> subNoRepeat(String s) {
        List<String> ans = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        char[] strArray = s.toCharArray();
        process2(strArray,0,hashSet,"");
        for (String ss : hashSet) {
            ans.add(ss);
        }
        return ans;
    }

    public void process2(char[] str, int index, HashSet<String>hashSet, String path) {
        if (index == str.length) {
            hashSet.add(path);
            return;
        }
        String no = path;
        process2(str, index + 1, hashSet, no);
        String yes = path + String.valueOf(str[index]);
        process2(str, index + 1, hashSet, yes);
    }

    public static void main(String[] args) {
        _字符串的全部子序列 o = new _字符串的全部子序列();
        String s = "aaa";
        List<String> list = o.subs(s);
        System.out.println(list);
    }

}
