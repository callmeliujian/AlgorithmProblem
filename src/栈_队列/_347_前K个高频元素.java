package 栈_队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _347_前K个高频元素 {

    // 思路
    //  1. 要统计元素出现频率
    //  2. 对频率排序
    //  3. 找出前K个高频元素
    // 首先统计元素出现的频率，这一类的问题可以使用map来进行统计。
    // 排序找出前K个高频元素 用小顶堆，因为要统计最大前k个元素，只有小顶堆每次将最小的元素弹出，最后小顶堆里积累的才是前k个最大元素。

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,hashMap.getOrDefault(num,0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        for (Map.Entry<Integer,Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1;  i >= 0; i--) {
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }

}
