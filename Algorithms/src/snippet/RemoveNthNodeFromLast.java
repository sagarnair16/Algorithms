package snippet;

class Solution {
	
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast=head;
        ListNode slow=head;
        int count=0;
        
        
        while(fast!=null){
            if(count!=n){
                fast=fast.next;
                count++;
            }
            else{
                fast=fast.next;
                slow=slow.next;
            }
        }
        
        if(count!=1){
        slow.val=slow.next.val;
        slow.next=slow.next.next;
        }
        else{
            slow=null;
        }
        
        return head;
    }
}


class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }