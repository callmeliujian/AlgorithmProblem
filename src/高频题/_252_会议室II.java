package 高频题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _252_会议室II {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 存放所有会议开始时间
        int[] begins = new int[intervals.length];
        // 存放所有会议结束时间
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i ++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // 排序
        Arrays.sort(begins);
        Arrays.sort(ends);

        int room = 0, endIdx = 0;
        for (int begin : begins) {
            if (begin >= ends[endIdx]) {
                endIdx++;
            } else { // 需要新开一个会议失
                room++;
            }
        }
        return room;
    }

    public int minMeetingRooms1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 按照会议开始时间，从小到大排序 nlogn
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
        // 创建一个最小堆（存放每一个会议结束时间）
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 添加0号会议的结束时间
        heap.add(intervals[0][1]);
        // 堆顶含义：目前占用的会议室中最早结束的时间
        for (int i = 1; i < intervals.length; i ++) { //nlogn
            // i号会议的开始时间 >= 对顶
            if (intervals[i][0] >= heap.peek()) {
                heap.remove();
            }
            // 将i号会议的结束时间加入堆中
            heap.add(intervals[i][0]);
        }
        return heap.size();
    }
}
