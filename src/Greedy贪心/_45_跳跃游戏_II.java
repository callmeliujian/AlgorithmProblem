package Greedy贪心;

//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
//
//        数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//        你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//        假设你总是可以到达数组的最后一个位置。
//        示例 1:
//
//        输入: nums = [2,3,1,1,4]
//        输出: 2
//        解释: 跳到最后一个位置的最小跳跃数是 2。
//             从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//        示例 2:
//
//        输入: nums = [2,3,0,1,4]
//        输出: 2
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/jump-game-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _45_跳跃游戏_II {
    // 用这个
    // https://leetcode.cn/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
    // 正向查找可到达的最大位置
    // 在具体的实现中，我们维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。
    // 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
    // 时间复杂度：O(n)，其中 n 是数组长度。
    //空间复杂度：O(1)。
    public int jump1(int[] nums) {
        int ans = 0;
        int end = 0;// 最面边界
        int maxPosition = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                ans++;
                end = maxPosition;
            }
        }
        return ans;
    }

    //  https://leetcode.cn/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
    //  方法一：反向查找出发位置
    //  我们的目标是到达数组的最后一个位置，因此我们可以考虑最后一步跳跃前所在的位置，该位置通过跳跃能够到达最后一个位置。
    //  如果有多个位置通过跳跃都能够到达最后一个位置，那么我们应该如何进行选择呢？直观上来看，我们可以「贪心」地选择距离最后一个位置最远的那个位置，也就是对应下标最小的那个位置。因此，我们可以从左到右遍历数组，选择第一个满足要求的位置。
    //  找到最后一步跳跃前所在的位置之后，我们继续贪心地寻找倒数第二步跳跃前所在的位置，以此类推，直到找到数组的开始位置
    //  时间复杂度：O(n2)，其中 n 是数组长度。有两层嵌套循环，在最坏的情况下，例如数组中的所有元素都是 1，position 需要遍历数组中的每个位置，对于 position 的每个值都有一次循环。
    //  空间复杂度：O(1)。

    public int jump(int[] nums) {
        int length = nums.length - 1;
        int ans = 0;
        while (length > 0) {
            for (int i = 0; i < length; i++) {
                if (i + nums[i] >= length) {
                    ans++;
                    length = i;
                    break;
                }
            }
        }
        return ans;
    }

}
