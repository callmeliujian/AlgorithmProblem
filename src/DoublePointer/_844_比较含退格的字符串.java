package DoublePointer;

public class _844_比较含退格的字符串 {

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skips = 0, skipt = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skips++;
                    i--;
                } else if (skips > 0) {
                    skips--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipt++;
                    j--;
                } else if (skipt > 0) {
                    skipt--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) { // 这条判断的原因 String s = "ab##"; String t = "c#d#";
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) { // 这条判断的原因 String s1 = "bxj##tw";String t1 = "bxj###tw";
                    return false;
                }
            }

            i--;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        _844_比较含退格的字符串 a = new _844_比较含退格的字符串();
        // 第一组测试用例
        String s = "ab##";
        String t = "c#d#";
        // 第二组测试用例
        String s1 = "bxj##tw";
        String t1 = "bxj###tw";
        // 第三组测试用例
        String s2 = "ab#c";
        String t2 = "ad#c";
        boolean res = a.backspaceCompare(s2,t2);
        System.out.println(res);
    }

}
