public class LeftRightList {
    //调整链表为左边全小于某值，右边全大于某值，中间等于某值
    public ListNode change(ListNode listNode,int value){
        ListNode left = null;
        ListNode leftHead = null;
        ListNode middle = null;
        ListNode middleHead = null;
        ListNode right = null;
        ListNode rightHead = null;
        ListNode temp = listNode;
        while(temp!=null){
            if(temp.getData()<value){
                if(left==null){
                    left = temp;
                    leftHead = temp;
                }else {
                    left.setNext(temp);
                    left = temp;
                }
            }else if(temp.getData() == value){
                if(middle==null){
                    middle = temp;
                    middleHead = temp;
                }else {
                    middle.setNext(temp);
                    middle = temp;
                }
            }else {
                if(right==null){
                    right = temp;
                    rightHead = temp;
                }else {
                    right.setNext(temp);
                    right = temp;
                }
            }
            temp = temp.getNext();
        }
        ListNode result = null;
        ListNode end = null;
        if(left!=null){
            result = leftHead;
            end = left;
        }
        if(middle!=null){
            if(result!=null){
                end.setNext(middleHead);
                end = middle;
            }else {
                result = middleHead;
                end = middle;
            }
        }
        if(right!=null){
            if(result!=null){
                end.setNext(rightHead);
                end = right;
            }else {
                result = rightHead;
            }
        }
        end.setNext(null);
        return result;
    }
}
