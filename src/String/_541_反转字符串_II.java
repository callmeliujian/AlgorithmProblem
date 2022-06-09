package String;

public class _541_反转字符串_II {

    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i+= 2 * k) {
            int start = i;
            int end = Math.min(charArray.length - 1, start + k - 1);
            while (start < end) {
                charArray[start] ^= charArray[end];
                charArray[end] ^= charArray[start];
                charArray[start] ^= charArray[end];
                start++;
                end--;
            }
        }
        return new String(charArray);
    }

}
