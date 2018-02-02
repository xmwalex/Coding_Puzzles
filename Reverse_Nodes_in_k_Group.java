/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p0,p1,p2;
        if(head==null||head.next==null)
            return head;
        p0 = new ListNode(0);
        p0.next=head;
        p1=head;
        p2=head;
        int count=0;
        while(p2!=null&&count<k){
            p2=p2.next;
            count++;
        }
        if(count<k)
            return head;
        p2=p1.next;
        count=0;
        while(count<k-1){
            p1.next=p2.next;
            p2.next=p0.next;
            p0.next=p2;
            p2=p1.next;
            count++;
        }
        p1.next=reverseKGroup(p2,k);
        return p0.next;
    }
    
}
