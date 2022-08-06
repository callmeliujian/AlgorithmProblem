package LinkedList;

//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
//         
//
//        示例 1：
//
//
//        输入：head = [1,1,2]
//        输出：[1,2]
//        示例 2：
//
//
//        输入：head = [1,1,2,3,3]
//        输出：[1,2,3]
//         
//
//        提示：
//
//        链表中节点数目在范围 [0, 300] 内
//        -100 <= Node.val <= 100
//        题目数据保证链表已经按升序 排列
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _83_删除排序链表中的重复元素 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p = head, q = head.next;
            while (q != null) {
                if (p.val == q.val) {
                    p.next = q.next;
                    q = p.next;
                } else {
                    p = p.next;
                    q = q.next;
                }
            }
            return head;
        }
    }

}
