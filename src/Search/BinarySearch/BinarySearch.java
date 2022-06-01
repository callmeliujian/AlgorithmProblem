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

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        int num = 10;
        boolean res = find(array,num);
        System.out.println(res);
    }

}
