package Linked_List;

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
