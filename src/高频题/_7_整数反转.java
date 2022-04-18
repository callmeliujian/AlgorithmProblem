package 高频题;

public class _7_整数反转 {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int preRes = res;
            res = preRes * 10 + x % 10;
            if ((res - x % 10) / 10 != preRes) return 0;
            x = x / 10;
        }
        return res;
    }

}
