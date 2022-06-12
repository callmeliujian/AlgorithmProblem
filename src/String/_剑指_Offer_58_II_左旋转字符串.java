package String;

public class _剑指_Offer_58_II_左旋转字符串 {

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        // 1. reverse [0,n]
        reverseString(sb,0,n - 1);
        // 2. reverse [n+1,s.length-1]
        reverseString(sb,n,sb.length() - 1);
        // 3. reverse [0,s.length-1]
        reverseString(sb,0,sb.length() - 1);
        return sb.toString();
    }

    // reverse [start,end]
    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        _剑指_Offer_58_II_左旋转字符串 a = new _剑指_Offer_58_II_左旋转字符串();
        String s = "abcdefg";
        int n = 2;
        String ans = a.reverseLeftWords(s,n);
        System.out.println(ans);
    }

}
