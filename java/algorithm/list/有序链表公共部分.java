public class ListCommon {
    //寻找两个有序链表公共部分
    public void find(ListNode l1,ListNode l2){
        if(l1==null||l2==null)
            return;
        while(l1!=null&&l2!=null){
            if(l1.getData()==l2.getData()){
                System.out.println(l1.getData());
                l1 = l1.getNext();
                l2 = l2.getNext();
            }
            else if(l1.getData()<l2.getData())
                l1 = l1.getNext();
            else if(l1.getData()>l2.getData())
                l2 = l2.getNext();
        }
    }
}
