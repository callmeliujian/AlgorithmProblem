package DifferenceArray_差分数组;

public class Demo {
    // 差分数组
    private int[] diff;

    public void difference(int [] nums) {
        diff = new int[nums.length];
        // 构造差分数组
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }
    /* 给闭区间 [i,j] 增加 val（可以是负数）*/
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int [] ans = new int[diff.length];
        // 根据差分数组构造结果数组
        ans[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }

}
