import java.util.Stack;

public class StackSort {
    //排序栈，使用另一个栈，及临时变量，将stack栈顶弹出存放在current中，如果help栈为空或当前
    //栈顶小于current，将help栈顶放入stack中，否则放入help中，不断循环，最后将help中数据弹出放在stack中
    public void sort(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        help.push(stack.pop());

        while(!stack.isEmpty()){
            int current = stack.pop();
            while(!help.isEmpty()&&help.peek()<current){
                stack.push(help.pop());
            }
            help.push(current);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
