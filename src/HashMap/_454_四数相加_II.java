package HashMap;

import java.util.HashMap;

public class _454_四数相加_II {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (hashMap.containsKey(sum)) {
                    hashMap.put(sum, hashMap.get(sum) + 1);
                } else {
                    hashMap.put(sum, 1);
                }
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int temp = 0 - (i + j);
                if (hashMap.containsKey(temp)) {
                    ans += hashMap.get(temp);
                }
            }
        }
        return ans;
    }

}
