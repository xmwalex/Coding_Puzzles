#Merge k sorted linked lists and return it as one sorted list.



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1)
            return null;
        return partition(lists,0,lists.length-1);
    }
    public ListNode partition(ListNode[] lists, int start,int end){
        if(start==end)
            return lists[start];
        if(start<end){
            int mid = (start+end)/2;
            ListNode n1 = partition(lists,start,mid);
            ListNode n2 = partition(lists,mid+1,end);
            return merge2Lists(n1,n2);
        }
        else
            return null;
    }
    public ListNode merge2Lists(ListNode Node1, ListNode Node2){
        ListNode p1=Node1;
        ListNode p2=Node2,tmp;
        if(p1==null)
            return p2;
        if(p2==null)
            return p1;
        Node1 = (p1.val<=p2.val)?p1:p2;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                while(p1.next!=null&&p1.next.val<=p2.val)
                    p1=p1.next;
                tmp=p1.next;
                p1.next=p2;
                p1=tmp;
            }
            else{
                tmp=p1;
                p1=p2;
                p2=tmp;
            }
                
        }
        return Node1;
    }
}
