package 动态规划;

public class _486_预测赢家 {

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
             return true;
        }
        if (first(nums, 0, nums.length - 1) >= second(nums, 0, nums.length - 1)) {
            return true;
        } else {
             return false;
        }
    }

    private int first(int[] array, int l, int r) {
        if (l == r) {
            return array[l];
        }
        return Math.max(
            array[l] + second(array, l + 1, r),
            array[r] + second(array, l, r - 1)
            );
    }

    private int second(int[] array, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(
            first(array, l + 1, r), 
            first(array, l, r - 1)
        );
    }

    public static void main(String[] args) {
        
    }

}
