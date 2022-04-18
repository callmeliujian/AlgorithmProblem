package 高频题;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        // 排序
        Arrays.sort(nums);
        // i 用来扫描三元组的第一个元素
        int lastIdx = nums.length - 1;
        int lastR = nums.length - 1;
        for (int i = 0; i < lastIdx; i ++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = lastR, remain = 0 - nums[i];
            while (l < r) {
                int sumlr = nums[l] + nums[r];
                if (sumlr == remain) { // 找到了符合条件的三元组
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    // 跳过相同的值（去重）
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    // 向中间逼近
                    l++;
                    r--;
                } else if (sumlr < remain) {
                    l++;
                } else  {
                    r--;
                }
            }
        }
        return res;
    }

}
