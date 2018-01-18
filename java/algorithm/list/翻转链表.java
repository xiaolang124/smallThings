public class ReverseList {
    public ListNode reverse(ListNode node){
        //翻转链表
        if(node==null||node.getNext()==null){
            return node;
        }
        ListNode head = null;
        ListNode now = node;
        ListNode next;
        while(now!=null){
            next = now.getNext();
            now.setNext(head);
            head = now;
            now = next;
        }
        return head;
    }
}
