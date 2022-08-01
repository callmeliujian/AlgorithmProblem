package DoublePointer;

public class _判断一个字符串是不是回文串 {

    boolean isPalindrome(String s) {
        if (s == null) return false;
        char[] sArray = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (sArray[left] != sArray[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        String s1 = "a";
        String s2 = "";
        String s3 = null;
        String s5 = "jkdhfkjafha";
        _判断一个字符串是不是回文串 o = new _判断一个字符串是不是回文串();
        boolean ans = o.isPalindrome(s5);
        System.out.println(ans);
    }

}
