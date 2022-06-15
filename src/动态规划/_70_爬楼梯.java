package 动态规划;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

public class _70_爬楼梯 {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int num1 = 1;
        int num2 = 2;
        for (int i = 2; i < n; i++) {
            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return num2;
    }

}
