package sliding_window;
import java.util.*;

//DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
//
//        例如，"ACGAATTCCG" 是一个 DNA序列 。
//        在研究 DNA 时，识别 DNA 中的重复序列非常有用。
//
//        给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
//
//         
//
//        示例 1：
//
//        输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//        输出：["AAAAACCCCC","CCCCCAAAAA"]
//        示例 2：
//
//        输入：s = "AAAAAAAAAAAAA"
//        输出：["AAAAAAAAAA"]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/repeated-dna-sequences
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _187_重复的DNA序列 {

    // https://labuladong.github.io/algo/2/20/28/
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            char[] sArray = s.toCharArray();
            int[] numArray = new int[sArray.length];
            int l = 10;
            int r = 4;
            int lr = (int)Math.pow(r,l -1);
            int window = 0;
            List<String> ans = new ArrayList<>();
            HashSet<Integer> allSet = new HashSet<>();
            HashSet<String> ansSet = new HashSet<>();
            for (int i = 0; i < sArray.length; i++) {
                char temp = sArray[i];
                switch (temp) {
                    case 'A':
                        numArray[i] = 0;
                        break;
                    case 'G':
                        numArray[i] = 1;
                        break;
                    case 'C':
                        numArray[i] = 2;
                        break;
                    case 'T':
                        numArray[i] = 3;
                        break;
                }
            }

            int left = 0, right = 0;
            while (right < numArray.length) {
                int num = numArray[right];
                right++;
                window = window * r + num;
                if (right - left == l) {
                    if (allSet.contains(window)) {
                        ansSet.add(s.substring(left, right));
                    } else {
                        allSet.add(window);
                    }
                    int leftNum = numArray[left];
                    left++;
                    window = window - leftNum * lr;
                }
            }
            return new LinkedList<>(ansSet);
        }
    }

}
