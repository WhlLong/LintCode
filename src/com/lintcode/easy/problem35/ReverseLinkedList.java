package com.lintcode.easy.problem35;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        node1.next = node2;


        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode newHead = reverseLinkedList.reverse(node1);
        System.out.println(newHead.val + " " + newHead.next.val);
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        // write your code here
        ListNode pre = head;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            head = next;
            next = next.next;
            head.next = pre;
            pre = head;

        }

        return head;
    }


}
