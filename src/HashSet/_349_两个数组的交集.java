package HashSet;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class _349_两个数组的交集 {

    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int index = 0, index1 = 0, index2 = 0;
        int[] array = new int[length1 + length2];
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                if (index == 0 || num1 != array[index - 1]) {
                    array[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(array,0,index);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1,set2);
    }

    private int[] getIntersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        HashSet<Integer> ansSet = new HashSet<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                ansSet.add(num);
            }
        }
        int[] ans = new int[ansSet.size()];
        int index = 0;
        for (int num : ansSet) {
            ans[index++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        _349_两个数组的交集 a = new _349_两个数组的交集();
        int[] array1 = new int[]{1,2,2,1};
        int[] array2 = new int[]{1,1};
        int[] res = a.intersection1(array1,array2);
        System.out.println(res);
    }

}
