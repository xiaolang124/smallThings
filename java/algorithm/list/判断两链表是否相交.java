public class ListIntersect {
    //判断两个链表是否相交
    public boolean check(ListNode headA,ListNode headB){
        if(headA==null||headB==null){
            return false;
        }
        int lenA = 0, lenB = 0, count = 0;
        ListNode p = headA;
        while(p!=null){
            ++lenA;
            p = p.getNext();
        }
        p = headB;
        while(p!=null){
            ++lenB;
            p = p.getNext();
        }
        ListNode l = null, s = null;
        if(lenA>lenB){
            l = headA;
            s = headB;
        }
        else {
            l = headB;
            s = headA;
        }
        count = (lenA>lenB)?(lenA-lenB):(lenB-lenA);
        while(count>0){
            l = l.getNext();
            --count;
        }
        while(l!=null&&s!=null){
            if(l==s)
                return true;
            l = l.getNext();
            s = s.getNext();
        }
        return false;
    }
}
