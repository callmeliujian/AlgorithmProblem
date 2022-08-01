package LinkedList;

//public static void main(String args[]) {
//        _707_设计链表 a = new _707_设计链表();
//        a.MyLinkedList();
//        a.addAtHead(2);
//        a.deleteAtIndex(1);
//        //a.addAtTail(3);
////        a.addAtIndex(1,2);
////        int value = a.get(1);
//        //value = a.get(1);
//        System.out.println("123");
//        }

class MyLinkedList {
    ListNode dummyHead;
    int listLength;

    public class ListNode {
        int value;
        ListNode next;
        ListNode(int val) {
            this.value = val;
        }
        ListNode(){}
    }

    public MyLinkedList() {
        dummyHead = new ListNode();
        listLength = 0;
    }

    public int get(int index) {
        if (index >= listLength) {
            return -1;
        } else {
            ListNode temp = dummyHead;
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
            return temp.value;
        }
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(listLength,val);
//        ListNode temp = dummyHead.next;
//        while (temp != null) {
//            temp = temp.next;
//        }
//        ListNode newNode = new ListNode(val);
//        temp.next = newNode;
//        newNode.next = null;
//        listLength++;
    }

    public void addAtIndex(int index, int val) {
        if (index > listLength) {
            return;
        } else {
            ListNode preNode = dummyHead;
            for (int i = 0; i < index; i++) {
                preNode = preNode.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = preNode.next;
            preNode.next = newNode;
            listLength++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= listLength) {
            return;
        } else {
            ListNode node = dummyHead;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            listLength--;
        }
    }
}