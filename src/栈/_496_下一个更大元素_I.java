package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

//nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
//
//        给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
//
//        对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
//
//        返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
//
//         
//
//        示例 1：
//
//        输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
//        输出：[-1,3,-1]
//        解释：nums1 中每个值的下一个更大元素如下所述：
//        - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//        - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
//        - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//        示例 2：
//
//        输入：nums1 = [2,4], nums2 = [1,2,3,4].
//        输出：[3,-1]
//        解释：nums1 中每个值的下一个更大元素如下所述：
//        - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
//        - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
//         
//
//        提示：
//
//        1 <= nums1.length <= nums2.length <= 1000
//        0 <= nums1[i], nums2[i] <= 104
//        nums1和nums2中所有整数 互不相同
//        nums1 中的所有整数同样出现在 nums2 中
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/next-greater-element-i
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _496_下一个更大元素_I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int currentNum = nums2[i];
            while (!stack.isEmpty() && stack.peekLast() < currentNum) {
                stack.removeLast();
            }
            hashMap.put(currentNum,stack.isEmpty() ? -1 : stack.peekLast());
            stack.addLast(currentNum);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }

}

// 单调栈 + hashmap
