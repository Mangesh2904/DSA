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
        if(left == right || head.next == null) return head;
        
        Stack<Integer> st = new Stack<>();

        ListNode temp = head;

        for(int i = 1; i < left; i++) temp = temp.next;

        ListNode start = temp;


        for(int i = left; i <= right; i++) {
            st.push(temp.val);
            temp = temp.next;
        }

        for(int i = left; i <= right; i++){
            int v = st.pop();
            start.val = v;
            start = start.next;
        }

        return head;
    }
}