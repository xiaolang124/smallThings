public class ListCopy {
    //复制带有随机节点指针的链表
    public ComplexNode copy(ComplexNode begin){
        ComplexNode result = null;
        if(begin==null||begin.next==null){
            result = new ComplexNode();
            result.val = begin.val;
            return begin;
        }
        ComplexNode now = begin;
        ComplexNode next;
        ComplexNode temp;
        //在节点后复制节点，如1->2->3复制成1->1'->2->2'->3->3'
        while(now!=null){
            next = now.next;
            temp = new ComplexNode();
            temp.val = now.val;
            now.next = temp;
            temp.next = next;
            now = next;
        }
        now = begin;
        while(now!=null){
            //复制链表的rand
            temp = now.next;
            next = temp.next;
            temp.rand = now.rand.next;
            now = next;
        }
        result = begin.next;
        now = begin;
        ComplexNode resultNow = result;
        ComplexNode nowNext,resultNext;
        //构建返回链表，整理next
        while(resultNow.next!=null){
            nowNext = resultNow.next;
            resultNext = nowNext.next;
            now.next = nowNext;
            resultNow.next = resultNext;
            now = nowNext;
            resultNow = resultNext;
        }
        now.next = null;
        return result;
    }
}