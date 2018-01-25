public class ListDelete {
    //删除链表指定值
    public ListNode delete(ListNode begin,int k){
        ListNode temp = begin;
        ListNode head = null, tail = null, next;
        while(temp!=null){
            next = temp.getNext();
            if(temp.getData()!=k){
                if(head==null){
                    head = temp;
                    temp.setNext(null);
                    tail = temp;
                }else {
                    tail.setNext(temp);
                    temp.setNext(null);
                    tail = temp;
                }
            }
            temp = next;
        }
        return head;
    }

}
