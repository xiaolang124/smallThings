public class ListCircleIntersect {
    //判断两个有环链表，是否相交
    public boolean check(ListNode headA,ListNode headB){
        ListCircle listCircle = new ListCircle();
        ListNode entryA = listCircle.find(headA);
        ListNode entryB = listCircle.find(headB);
        if(entryA==null||entryB==null)
            return false;
        if(entryA==entryB){
            //找到第一个相交节点
            int numA = 0, numB = 0, count = 0;
            ListNode p = headA;
            while(p!=entryA){
                ++numA;
                p = p.getNext();
            }
            p = headB;
            while(p!=entryB){
                ++numB;
                p = p.getNext();
            }
            ListNode l = null, s = null;
            if(numA>numB){
                l = headA;
                s = headB;
            }else {
                l = headB;
                s = headA;
            }
            count = Math.abs(numA-numB);
            while(count>0){
                l = l.getNext();
                --count;
            }
            while (l!=entryA&&s!=entryB){
                if(l==s){
                    break;
                }
                s = s.getNext();
                l = l.getNext();
            }

            return true;
        }else {
            ListNode p = entryA.getNext();
            while(p!=entryA){
                if(p==entryB){
                    return true;
                }
                p = p.getNext();
            }
            return false;
        }
    }
}

class ListIntersect {
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

