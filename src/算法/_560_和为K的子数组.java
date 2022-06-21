package 算法;

import java.util.HashMap;

public class _560_和为K的子数组 {

    public int subarraySum1(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int preSum = 0;
        // 前缀和为0的个数为1个
        hashMap.put(0,1);
        for (int num : nums) {
            preSum += num;
            if (hashMap.containsKey(preSum - k)) {
                ans += hashMap.get(preSum - k);
            }
            hashMap.put(preSum, hashMap.getOrDefault(preSum,0) + 1);
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        // 前缀和数组
        int []preSum = new int[length + 1];
        preSum[0] = 0;
        for (int i = 0; i < length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < length; left++) {
            for (int right = left; right < length; right++) {
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
