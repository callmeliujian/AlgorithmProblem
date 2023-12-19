package String;


//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
//
//示例 1：
//
//输入:a = "11", b = "1"
//输出："100"
//示例 2：
//
//输入：a = "1010", b = "1011"
//输出："10101"
//提示：
//
//        1 <= a.length, b.length <= 104
//a 和 b 仅由字符 '0' 或 '1' 组成
//字符串如果不是 "0" ，就不含前导零

public class _67_二进制求和 {

    class Solution1 {
        public String addBinary(String a, String b) {
            char[] aArray = a.toCharArray();
            char[] bArray = b.toCharArray();
            StringBuilder sBuilder = new StringBuilder();
            int carry = 0;
            for(int i = aArray.length - 1, j = bArray.length - 1; i >=0 || j >=0; i --, j-- ) {
                char aItem = i >= 0 ? aArray[i] : '0';
                char bItem = j >= 0 ? bArray[j] : '0';
                int sum = (aItem - '0') + (bItem - '0') + carry;
                sBuilder.append(sum%2);
                carry = sum / 2;
            }
            if (carry > 0) {
                sBuilder.append(carry);
            }
            return sBuilder.reverse().toString();
        }
    }

    class Solution {
        public String addBinary(String a, String b) {
            char[] aArray = a.toCharArray();
            char[] bArray = b.toCharArray();
            int aLength = aArray.length;
            int bLength = bArray.length;
            StringBuilder sBuilder = new StringBuilder();
            int carray = 0;
            for(int i = aLength - 1, j = bLength - 1; i >=0 || j >=0; i --, j-- ) {
                char aItem = '0';
                char bItem = '0';
                if (i >= 0) {
                    aItem = aArray[i];
                }
                if (j >= 0) {
                    bItem = bArray[j];
                }
                int sum = (aItem - '0') + (bItem - '0') + carray;
                sBuilder.append(sum%2);
                carray = sum / 2;
            }
            if (carray > 0) {
                sBuilder.append(carray);
            }
            return sBuilder.reverse().toString();
        }
    }

}
