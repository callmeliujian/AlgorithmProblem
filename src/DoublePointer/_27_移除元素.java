package DoublePointer;

// 双指针
public class _27_移除元素 {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int normalIndex = 0;
        for (int fastIndex = 0; fastIndex < length; fastIndex ++) {
            if (nums[fastIndex] != val) {
                nums[normalIndex] = nums[fastIndex];
                normalIndex++;
            }
        }
        return normalIndex;
    }

}
