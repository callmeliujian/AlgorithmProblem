package Array.LoopArray;
import java.util.*;

//你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
//
//        为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
//
//        如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
//        如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
//        如果 k == 0 ，将第 i 个数字用 0 替换。
//        由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
//
//        给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
//
//         
//
//        示例 1：
//
//        输入：code = [5,7,1,4], k = 3
//        输出：[12,10,16,13]
//        解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
//        示例 2：
//
//        输入：code = [1,2,3,4], k = 0
//        输出：[0,0,0,0]
//        解释：当 k 为 0 时，所有数字都被 0 替换。
//        示例 3：
//
//        输入：code = [2,4,9,3], k = -2
//        输出：[12,5,6,13]
//        解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/defuse-the-bomb
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1652_拆炸弹 {
    // https://leetcode.cn/problems/defuse-the-bomb/solution/by-ac_oier-osbg/
    class Solution {
        public int[] decrypt(int[] code, int k) {
            int length = code.length;
            int[] ans = new int[length];
            if (k == 0) {
                Arrays.fill(ans,0);
            } else if (k > 0) {
                for (int i = 0; i < length; i++) {
                    int sum = 0;
                    for (int j = 1; j <= k; j++) {
                        int index = (i + j) % length;
                        int num = code[index];
                        sum += num;
                    }
                    ans[i] = sum;
                }
            } else {
                // k < 0
                // 用一个原来 2 倍大的数组，来去找前面的 i 前面的数字，方便计算
                int[] copyArray = new int[2 * length];
                for (int i = 0; i < 2 * length; i++) {
                    copyArray[i] = code[i % length];
                }
                for (int i = 0; i < length; i++) {
                    int sum = 0;
                    for (int j = k; j < 0; j ++) {
                        int index = i + length + j;
                        sum += copyArray[index];
                    }
                    ans[i] = sum;
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int[] decrypt(int[] code, int k) {
            int length = code.length;
            int[] ans = new int[length];
            if (k == 0) {
                Arrays.fill(ans,0);
            } else if (k > 0) {
                for (int i = 0; i < length; i++) {
                    int sum = 0;
                    for (int j = 1; j <= k; j++) {
                        int index = (i + j) % length;
                        int num = code[index];
                        sum += num;
                    }
                    ans[i] = sum;
                }
            } else {
                for (int i = 0; i < length; i++) {
                    for(int j = k; j < 0;j++) {
                        int index = (i + j + code.length) % code.length;
                        ans[i] += code[index];
                    }
                }
            }
            return ans;
        }
    }

}
