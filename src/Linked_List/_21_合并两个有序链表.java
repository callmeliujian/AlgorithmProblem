package Linked_List;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//         
//
//        示例 1：
//
//
//        输入：l1 = [1,2,4], l2 = [1,3,4]
//        输出：[1,1,2,3,4,4]
//        示例 2：
//
//        输入：l1 = [], l2 = []
//        输出：[]
//        示例 3：
//
//        输入：l1 = [], l2 = [0]
//        输出：[0]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/merge-two-sorted-lists
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
        ListNode currentNode = dummyNode;
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                currentNode.next = node2;
                node2 = node2.next;
            } else {
                currentNode.next = node1;
                node1 = node1.next;
            }
            currentNode = currentNode.next;
        }
        if (node1 != null) {
            currentNode.next = node1;
        }
        if (node2 != null) {
            currentNode.next = node2;
        }
        return dummyNode.next;
    }

}
