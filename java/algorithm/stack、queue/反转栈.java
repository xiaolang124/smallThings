import java.util.Stack;

public class ReverseStack {

    //返回栈底元素
    public int get(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = get(stack);
            stack.push(result);
            return last;
        }
    }

    //逆序栈，
    public void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = get(stack);
        reverse(stack);
        stack.push(i);
    }

}
