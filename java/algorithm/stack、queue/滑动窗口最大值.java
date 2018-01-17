import java.util.LinkedList;

public class WindowMax {
    public void window(int[] array,int len){
        //滑动窗口最大值，双端队列，如果队尾对应的值小于下一个值，直接弹出，否则压入，
        //如果最左侧位置超出窗口限制，弹出
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0;i<array.length;++i){
            if(linkedList.isEmpty()){
                linkedList.addLast(i);
            }else {
                while(!linkedList.isEmpty()&&
                        array[linkedList.peekLast()]<=array[i]){
                    linkedList.pollLast();
                }
                linkedList.addLast(i);
            }
            if(i>=len-1){
                if(linkedList.getFirst()<=i-len){
                    linkedList.pollFirst();
                }
                System.out.println(array[linkedList.peekFirst()]);
            }
        }
    }
}
