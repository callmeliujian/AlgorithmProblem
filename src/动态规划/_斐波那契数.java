package 动态规划;

import java.util.Arrays;
import java.util.Vector;

import static java.util.Arrays.fill;

public class _斐波那契数 {

    // 递归
    public int fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // 带备忘录的递归算法，自顶向下
    public int fib1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] array = new int[n + 1];
        Arrays.fill(array,0);
        array[1] = 1;
        array[2] = 1;
        return helper(array,n);
    }

    private int helper(int[] array,int n) {
        if (n > 0 && array[n] == 0) {
            array[n] = helper(array,n - 1) + helper(array,n - 2);
        }
        return array[n];
    }

    // 带备忘录的递归算法，自底向上
    public int fib2(int n) {
        if (n < 1) {
            return 0;
        }
        int[] array = new int[n + 1];
        Arrays.fill(array,0);
        array[1] = 1;
        array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public int fib3(int n) {
        if (n < 3) {
            return 1;
        }
        int num1 = 1;
        int num2 = 1;
        for (int i = 3; i <= n; i++) {
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        return num2;
    }


    public static void main(String[] args) {
        _斐波那契数 f = new _斐波那契数();
        int res = f.fib3(7);
        System.out.println(res);
    }

}
