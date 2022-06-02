package Search.BinarySearch;

public class BinarySearch {

    public static boolean find(int[]array, int num) {
        if (array == null || array.length == 0) {
            return false;
        }
        int L = 0;
        int R = array.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (array[mid] == num) {
                return true;
            } else if (array[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    // 有序数组中找到 >= num 最左的位置
    public static int mostLeftLessNumIndex(int[] array, int num) {
        int res = -1;
        if (array == null || array.length == 0) {
            return res;
        }
        int L = 0, R = array.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (array[mid] >= num) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }

    // 有序数组中找到 <= num 最右的位置
    public static int mostRightMaxNumIndex(int[] array, int num) {
        int res = -1;
        if (array == null || array.length == 0) {
            return res;
        }
        int L = 0, R = array.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (array[mid] <= num) {
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
    }

    // 局部最小值问题
    // array 相邻的数不相等
    // array 整体无序
    public static int oneMinIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int N = array.length;
        if (N == 1) {
            return 0;
        }
        if (array[0] < array[1]) {
            return 0;
        }
        if (array[N - 1] < array[N - 2]) {
            return N- 1;
        }
        int L = 0,R = N - 1;
        // L..R 肯定有局部最小值
        // 为什么不是 while(L <= R) 用例 32323，数组越界，因为要用 mid - 1
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (array[mid] < array[mid - 1] && array[mid] < array[mid + 1]) {
                return mid;
            } else {
                // 左 > 我 我 > 右
                // 左 < 我 我 < 右
                // 左 < 我 我 > 右
                if (array[mid] > array[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return array[L] < array[R] ? L : R;
    }

    // 左神源代码
    // arr 相邻的数不相等！
    public static int oneMinIndex1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        // L...R 肯定有局部最小
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,2,3,4,5,6,7};
        int num = 2;
        boolean res = find(array,num);
        int res1 = mostLeftLessNumIndex(array,num);
        int res2 = mostRightMaxNumIndex(array,num);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
    }

}
