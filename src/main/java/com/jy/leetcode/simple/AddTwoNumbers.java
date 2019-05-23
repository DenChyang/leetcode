package com.jy.leetcode.simple;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @author DengQiang.Wu
 * @create 2019-05-23 13:42
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println("123");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int result = l1.val + l2.val;
        // 进位处理
        if (result >= 10) {
            result = result-10;
            ListNode next = l1.next;
            if (next == null) {
                //l1.setNext(new ListNode(1));
                l1.next = new ListNode(1);
            }else{
                //next.setVal(next.getVal()+1);
                next.val = next.val+1;
            }
        }
        // 赋值处理
        ListNode listNode = new ListNode(result);

        // 递归
        l1 = l1.next;
        l2 = l2.next;
        if (l1 == null && l2 == null) {
            return listNode;
        }else{
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
        }
        listNode.next = addTwoNumbers(l1, l2);
        return listNode;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
