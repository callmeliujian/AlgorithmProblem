package DoublePointer;
import java.util.*;

public class _658_找到K个最接近的元素 {

//    给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
//
//    整数 a 比整数 b 更接近 x 需要满足：
//
//            |a - x| < |b - x| 或者
//|a - x| == |b - x| 且 a < b
// 
//
//    示例 1：
//
//    输入：arr = [1,2,3,4,5], k = 4, x = 3
//    输出：[1,2,3,4]
//    示例 2：
//
//    输入：arr = [1,2,3,4,5], k = 4, x = -1
//    输出：[1,2,3,4]
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode.cn/problems/find-k-closest-elements
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    class Solution {
        // https://leetcode.cn/problems/find-k-closest-elements/solution/pai-chu-fa-shuang-zhi-zhen-er-fen-fa-python-dai-ma/
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left =0, right = arr.length - 1;
            int removeNum = arr.length - k;
            while (removeNum > 0) {
                if (Math.abs((arr[left] - x)) == Math.abs((arr[right] - x))) {
                    if (arr[left] < arr[right]) {
                        right--;
                    } else {
                        left++;
                    }
                } else {
                    if (Math.abs((arr[left] - x)) < Math.abs((arr[right] - x))) {
                        right --;
                    } else {
                        left ++;
                    }
                }
                removeNum --;
            }
            List<Integer> ans = new ArrayList<>();
            for (; left <= right; left++) {
                ans.add(arr[left]);
            }
            return ans;
        }
    }

}
