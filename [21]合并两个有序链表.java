//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeListDirectV2(l1, l2);
    }

    private ListNode mergeListDirectV1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null, cur = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = cur = l1;
                } else {
                    cur.next = l1;
                    cur = l1;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = cur = l2;
                } else {
                    cur.next = l2;
                    cur = l2;
                }
                l2 = l2.next;
            }
            cur.next = null;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head;
    }

    private ListNode mergeListDirectV2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
            cur.next = null;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }

    private ListNode mergeListRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeListRecursive(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeListRecursive(l1, l2.next);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
