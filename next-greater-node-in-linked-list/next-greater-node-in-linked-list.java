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
    public int[] nextLargerNodes(ListNode head) {
      ArrayList<Integer>arr=new ArrayList<>();
        while(head!=null)
        {
            arr.add(head.val);
            head=head.next;
        }
        int[] res=new int[arr.size()];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<arr.size();i++)
        {
            while(!s.isEmpty() && arr.get(s.peek())<arr.get(i))
                res[s.pop()]=arr.get(i);
            s.push(i);
        }
        
        return res;
    }
}