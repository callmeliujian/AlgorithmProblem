package PrefixSum_前缀和;

public class Demo {
    // https://zhuanlan.zhihu.com/p/301509170
    // 前缀和数组
    private int[] prefixSum;

    /* 输入一个数组，构造前缀和 */
    public void prefixSum(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            // 计算 nums 的累加和
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }

    /* 查询闭区间 [i, j] 的累加和 */
    public int query(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        int[] nums = new int[]{1,2,3,4,5};
        d.prefixSum(nums);
        for (int i = 0; i < d.prefixSum.length; i++) {
            System.out.println(d.prefixSum[i]);
        }

        int ans = d.query(0,3);
        System.out.println(ans);

    }

}
