package 排序;

// 选择排序
// 每次找出最小值的位置，之后交换

public class SelectionSort {

    public static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < length; j ++) {
               if (array[j] < array[minValueIndex]) {
                   minValueIndex = j;
                }
            }
            swap(array,i,minValueIndex);
        }
    }

    private static void swap(int[] array,int i,int j) {
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
        selectionSort(array);
        printArray(array);
    }

}
