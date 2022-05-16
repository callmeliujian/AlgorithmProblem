package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _581_最短无序连续子数组 {

    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0];
        int min = nums[nums.length - 1];
        int begin = 0;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {  //从左到右维持最大值，寻找右边界end
                max = nums[i];
            } else {
                end = i;
            }
            if (nums[nums.length - 1 - i] <= min) { //从右到左维持最小值，寻找左边界begin
                min = nums[nums.length - 1 - i];
            } else {
                begin = nums.length - 1 - i;
            }
        }
        return end - begin + 1;
    }

    public static void main(String args[]) {
        //int[] strArray = {2,6,4,8,10,9,15};
        int[] strArray = {1,2,3,4};
        //int[] strArray = {1,3,5,4,2};
        _581_最短无序连续子数组 b = new _581_最短无序连续子数组();
        int index = b.findUnsortedSubarray(strArray);
        System.out.print(index);
    }

}
