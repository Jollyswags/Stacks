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
    public void reorderList(ListNode head) {
      if(head.next==null){
            return ;
        }
        
        ListNode s= head, f= head.next;
        
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        s=s.next;//s will be placed at the start of the stack 

        ListNode p =head, q=s;
        Deque<ListNode> stack= new ArrayDeque<>();
        Queue<ListNode> queue= new LinkedList<>();
        
        while(p!=s || q!=null){
            if(p!=s){
                queue.offer(p);
                p=p.next;
            }
            if(q!=null){
                stack.push(q);
                q=q.next;
            }
        }
        
        ListNode res= queue.poll(), t= res;
        
        while(!queue.isEmpty() || !stack.isEmpty()){
            if(!stack.isEmpty()){
                t.next= stack.poll();
                t=t.next;
            }
            if(!queue.isEmpty()){
                t.next= queue.poll();
                t=t.next;
            }
        }
        t.next=null;
        t=t.next;
        head= res;
    }
}