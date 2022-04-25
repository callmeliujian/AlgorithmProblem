package 高频题;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) return new int[]{idx,i};
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        //map.con
        int vale = map.get('k');
    }
}
