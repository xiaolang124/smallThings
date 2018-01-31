public class ListCircle {
    //https://www.cnblogs.com/zhuzhenwei918/p/7491892.html
    public ListNode find(ListNode begin){
       if(begin==null||begin.getNext()==null){
           return null;
       }
       ListNode slow = begin;
       ListNode fast = begin;
       while(fast.getNext()!=null&&fast.getNext().getNext()!=null){
           slow = slow.getNext();
           fast = fast.getNext().getNext();
           if(slow==fast){
               fast = begin;
               while(fast!=slow){
                   fast = fast.getNext();
                   slow = slow.getNext();
               }
               return fast;
           }
       }
       return null;
    }
}
