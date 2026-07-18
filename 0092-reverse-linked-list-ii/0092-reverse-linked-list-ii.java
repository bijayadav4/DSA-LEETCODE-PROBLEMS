/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        for(int i = 1; i<left; i++){
            prev  = current;
            current = current.next;
        }
        ListNode connection = prev;
        ListNode tail = current;
        for( int i = 0; i < right-left+1; i++){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if(connection != null){
            connection.next = prev;
        } else {
            head = prev;
        }
        tail.next = current;
        return head;
    }
}