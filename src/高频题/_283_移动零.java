package 高频题;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//         
//
//        示例 1:
//
//        输入: nums = [0,1,0,3,12]
//        输出: [1,3,12,0,0]
//        示例 2:
//
//        输入: nums = [0]
//        输出: [0]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/move-zeroes
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _283_移动零 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            // 不加这个当数组不存在的时候就会有问题
            if (current != i) {
                nums[current] = nums[i];
                nums[i] = 0;
            }
            current++;
        }
    }

}
