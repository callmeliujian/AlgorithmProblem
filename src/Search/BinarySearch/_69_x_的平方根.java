package Search.BinarySearch;

public class _69_x_的平方根 {
    public int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            // mid *mid 有可能益处，所以转化为 long
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 2147395599;
        int left = 0, right = x, res = -1;
        int mid = (left + right) / 2;
        long b = (long) mid * (long)mid;
        System.out.println(b);

    }


}
