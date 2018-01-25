import java.util.Stack;

public class ListPalindrome {
    //判断链表是否回文，快慢两个指针
    public boolean judge(ListNode begin){
        if(begin==null||begin.getNext()==null)
            return true;
        Stack<Integer> stack = new Stack<>();
        ListNode fast = begin;
        ListNode slow = begin;
        while(slow!=null){
            if(fast.getNext()!=null&&fast.getNext().getNext()!=null){
                fast = fast.getNext().getNext();
                stack.push(slow.getData());
                slow = slow.getNext();
            }else{
                if(fast.getNext()!=null){
                    stack.push(slow.getData());
                }
                slow = slow.getNext();
                break;
            }
        }
        while(slow!=null){
            if(slow.getData()!=stack.pop()){
                return false;
            }
            slow = slow.getNext();
        }
        return true;
    }
}
