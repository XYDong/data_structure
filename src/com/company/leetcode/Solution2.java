package com.company.leetcode;

/**
 * @version 1.0.0
 * @ClassName Solution2.java
 * @Package com.company.leetcode
 * @Author Joker
 * @Description 链表操作
 * @CreateTime 2021年01月08日 10:10:00
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while ( prev.next != null ) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
//    public ListNode removeElements2(ListNode head, int val) {
//        if (head == null) {
//            return null;
//        }
//        head.next = removeElements2(head.next,val);
//        if (head.next.val == val) {
//            return head.next;
//        } else {
//            return head;
//        }
//    }
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;

    }

}
