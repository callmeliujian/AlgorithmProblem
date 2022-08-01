package LinkedList;

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
//         
//
//        示例 1：
//
//
//        输入：head = [1,2,2,1]
//        输出：true
//        示例 2：
//
//
//        输入：head = [1,2]
//        输出：false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/palindrome-linked-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _234_回文链表 {

    class Solution {

        ListNode left;

        public boolean isPalindrome(ListNode head) {
            left = head;
            return traverse(head);
        }

        private boolean traverse(ListNode right) {
            if (right == null) return true;
            boolean res = traverse(right.next);
            if (left.val != right.val) return false;
            left = left.next;
            return res;
        }

    }

}
