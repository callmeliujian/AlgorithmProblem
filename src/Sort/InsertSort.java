package Sort;

// 插入排序

public class InsertSort {
    public static void insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int end = 1; end < length; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && array[newNumIndex - 1] > array[newNumIndex]) {
                swap(array,newNumIndex - 1, newNumIndex);
                newNumIndex --;
            }
        }
    }

    public static void insertSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int end = 1; end < length; end++) {
            int newNumIndex = end;
            for (int pre = end - 1; pre >= 0 && array[pre] > array[pre + 1]; pre --) {
                swap(array,pre,pre + 1);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length;i++) {
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {5,3,8,1,2,0,7,5,6,1,5,9,0,6};
        //insertSort(array);
        insertSort1(array);
        printArray(array);
    }

}
