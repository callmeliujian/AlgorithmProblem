package 栈;

//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
//
//        数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
//
//         
//
//        示例 1:
//
//        输入: nums = [1,2,1]
//        输出: [2,-1,2]
//        解释: 第一个 1 的下一个更大的数是 2；
//        数字 2 找不到下一个更大的数；
//        第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
//        示例 2:
//
//        输入: nums = [1,2,3,4,3]
//        输出: [2,3,4,-1,4]
//         
//
//        提示:
//
//        1 <= nums.length <= 104
//        -109 <= nums[i] <= 109
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/next-greater-element-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _503_下一个更大元素_II {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i % n]) {
                res[stack.removeLast()] = nums[i % n];
            }
            stack.addLast(i % n);
        }
        return res;
    }

}

//建立「单调递减栈」，并对原数组遍历一次：
//
//        如果栈为空，则把当前元素放入栈内；
//        如果栈不为空，则需要判断当前元素和栈顶元素的大小：
//        如果当前元素比栈顶元素大：说明当前元素是前面一些元素的「下一个更大元素」，则逐个弹出栈顶元素，直到当前元素比栈顶元素小为止。
//        如果当前元素比栈顶元素小：说明当前元素的「下一个更大元素」与栈顶元素相同，则把当前元素入栈。
//
//        作者：fuxuemingzhu
//        链接：https://leetcode.cn/problems/next-greater-element-ii/solution/dong-hua-jiang-jie-dan-diao-zhan-by-fuxu-4z2g/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
