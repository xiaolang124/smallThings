import java.util.Stack;

public class StackQueue {

    //利用两个栈实现队列，
    //1、数据一次倒完
	//2、不为空，不能倒数据
    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();

    public int peek(){
        if(stackPop.size()==0&&stackPush.size()==0){
            return -1;
        }
        if(stackPop.size()==0){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public int pop(){
        if(peek()==-1){
            return -1;
        }
        return stackPop.pop();
    }

    public void push(int i){
        stackPush.push(i);
    }
}
