package Heap;
import java.util.PriorityQueue;
import common.ListNode;

//给你一个链表数组，每个链表都已经按升序排列。
//
//        请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//         
//
//        示例 1：
//
//        输入：lists = [[1,4,5],[1,3,4],[2,6]]
//        输出：[1,1,2,3,4,4,5,6]
//        解释：链表数组如下：
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        将它们合并到一个有序链表中得到。
//        1->1->2->3->4->4->5->6
//        示例 2：
//
//        输入：lists = []
//        输出：[]
//        示例 3：
//
//        输入：lists = [[]]
//        输出：[]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/merge-k-sorted-lists
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _23_合并K个升序链表 {

    class Solution {
        // https://labuladong.github.io/algo/2/19/18/
        // 优先队列 pq 中的元素个数最多是 k，所以一次 poll 或者 add 方法的时间复杂度是 O(logk)；所有的链表节点都会被加入和弹出 pq，所以算法整体的时间复杂度是 O(Nlogk)，其中 k 是链表的条数，N 是这些链表的节点总数。
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummyHead = new ListNode();
            ListNode p = dummyHead;
            PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b)->(a.val - b.val));
            for (ListNode item : lists) {
                if (item != null) {
                    queue.offer(item);
                }
            }
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                if (node.next != null) {
                    queue.offer(node.next);
                }
                p.next = node;
                p = p.next;
            }
            return dummyHead.next;
        }
    }

}