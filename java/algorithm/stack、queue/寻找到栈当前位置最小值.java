import java.util.Stack;

public class StackMin {
    //找数组到当前位置的最小值，使用两个栈，一个保存数组，另一个保存数组当前最小值，
    //如果当前值小于等于最小栈顶值，压入最小值栈，否则不压入，
    //弹出时，如果最小值栈顶小于当前值，只获取值不弹出，否则弹出
    public void find(int[] data){
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        for(int i=data.length-1;i>=0;--i){
            first.push(data[i]);
            if(second.empty()||second.peek()>=first.peek()){
                second.push(data[i]);
            }
        }

        for(int i=0;i<data.length;++i){
            if(second.peek()<first.pop()){
                System.out.println(second.peek());
            }else {
                System.out.println(second.pop());
            }
        }
    }
}
