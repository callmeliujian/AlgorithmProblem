package 算法;

public class _打印数字的二进制位 {

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & ( 1 << i) ) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int a = Integer.MIN_VALUE;
//        int b = ~a;
//        a == b;
//        print(a);
//        print(a >> 1);
//        print(a >>> 1);
    }

}
