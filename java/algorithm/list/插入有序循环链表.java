public class InsertLoopList {
    public ListNode insert(ListNode root,int a){
        //插入有序循环链表，链表为空，建立链表返回，否则寻找now小于等于该值，next大于等于该值位置插入
        //如果到最后依然没插入，放在头节点前面，判断当前值和头结点大小，如果小于，新节点为头节点，否则头节点依然是头结点
        ListNode temp = new ListNode(a);
        if(root==null){
            temp.setNext(temp);
            return root;
        }else {
            ListNode now = root;
            ListNode next = root.getNext();
            while(next!=root){
                if(now.getData()<=a&&next.getData()>=a){
                    now.setNext(temp);
                    temp.setNext(next);
                    return root;
                }
                now = next;
                next = next.getNext();
            }
            now.setNext(temp);
            temp.setNext(next);
            if(root.getData()<a){
                return root;
            }else {
                return temp;
            }
        }

    }
}
