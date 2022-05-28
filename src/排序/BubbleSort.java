package 排序;

// 冒泡排序
// 两两比较，每一轮找到最大值放到最后

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int end = length - 1; end >= 0; end--) {
            for (int second = 1; second <= end; second ++) {
                if (array[second - 1] > array[second]) {
                    swap(array,second - 1,second);
                }
            }
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
        bubbleSort(array);
        printArray(array);
    }

}
