package 动态规划;

public class _91_解码方法 {

    public int numDecodings(String s) {
        char[] str = s.toCharArray();
        return process(str, 0);
    }

    // str[0...1]已经转化完了，固定了
    // i之前的位置，如果转化已经做过决定了，不用再关心
    // i... 有多少种转化结果
    public int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        // i 没有到终止位置，但是 i 如果为 0 则不存在结果
        if(str[index] == '0') {
            return 0;
        }
        if (str[index] == '1') {
            int res = process(str, index + 1); // i 自己作为单独的部分，后续有多少种方法。
            if (index + 1 < str.length) {
                res += process(str, index + 2); // (i 和 i + 1) 作为单独的部分，后续有多少种方法
            }
            return res;
        }
        if (str[index] == '2') {
            int res = process(str, index + 1); // // i 自己作为单独的部分，后续有多少种方法。
            // (i 和 i+1)作为单独的部分并且没有超过26，后续有多少种方法
            if (index + 1 < str.length && (str[index + 1] >= '0' && str[index + 1] <= '6')) {
                res += process(str, index + 2);
            }
            return res;
        }
        // str[i] == '3' ~ '9'
        return process(str, index+1);
    }

    public static void main(String[] args) {
        String str = "12";
        _91_解码方法 o = new _91_解码方法();
        int res = o.numDecodings(str);
        System.out.println(res);
    }
    
}
