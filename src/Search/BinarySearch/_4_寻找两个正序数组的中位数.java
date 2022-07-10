package Search.BinarySearch;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//        算法的时间复杂度应该为 O(log (m+n)) 。
//
//         
//
//        示例 1：
//
//        输入：nums1 = [1,3], nums2 = [2]
//        输出：2.00000
//        解释：合并数组 = [1,2,3] ，中位数 2
//        示例 2：
//
//        输入：nums1 = [1,2], nums2 = [3,4]
//        输出：2.50000
//        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


public class _4_寻找两个正序数组的中位数 {



    // https://leetcode.cn/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
    // 时间负责度O(m+n) 空间O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int lenght = length1 + length2;
        int left = -1, right = -1;
        int leftStart = 0, rightStart = 0;
        for (int i = 0; i <= lenght/ 2; i++) {
            left = right;
            if (leftStart < length1 && (rightStart >= length2 || nums1[leftStart] < nums2[rightStart])) {
                right = nums1[leftStart++];
            } else {
                right = nums2[rightStart++];
            }
        }
        if ((lenght & 1) == 1) {
            return right;
        } else {
            return (left + right) / 2.0;
        }
    }

}
