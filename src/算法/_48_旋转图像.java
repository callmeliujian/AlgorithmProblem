package 算法;

public class _48_旋转图像 {

    // 时间复杂度O(N2）
    // 空间复杂度O(1）
    public void rotate1(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length/2; i++) {
            for (int j = 0; j < (length + 1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;
            }
        }
    }

    // 时间复杂度O(N2）
    // 空间复杂度O(N2）
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] newArray = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                newArray[j][length-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = newArray[i][j];
            }
        }
    }

}
