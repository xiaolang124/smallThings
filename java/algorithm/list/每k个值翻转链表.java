public class ReverseKList {
    //链表每k个节点逆序
    public ListNode reverse(ListNode head, int k){
        if(head==null||k<2)
            return head;
        ListNode p = head, q = head, tail = null;
        int i = 1, count = 0;
        while(q!=null){
            if(i==k){
                if(count==0)
                    head = q;
                else
                    tail.setNext(q);
                ListNode temp1 = q.getNext(), temp2;
                while(q!=p){
                    temp2 = p.getNext();
                    if(q.getNext()==temp1)
                        tail = p;
                    p.setNext(q.getNext());
                    q.setNext(p);
                    p = temp2;
                }
                p = q = temp1;
                i = 1;
                ++count;
            }
            if(q!=null){
                q = q.getNext();
            }
            ++i;
        }
        return head;
    }
}
