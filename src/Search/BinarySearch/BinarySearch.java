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

    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,2,3,4,5,6,7};
        int num = 100;
        boolean res = find(array,num);
        int res1 = mostLeftLessNumIndex(array,num);
        System.out.println(res);
        System.out.println(res1);
    }

}
