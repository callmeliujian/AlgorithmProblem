package DoublePointer;

public class _977_有序数组的平方 {

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1;
        for (int start = res.length - 1; start >= 0; start--) {
            int ans1 = nums[i] * nums[i];
            int ans2 = nums[j] * nums[j];
            if (ans1 > ans2) {
                res[start] = ans1;
                i++;
            } else {
                res[start] = ans2;
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("123");
    }

}
