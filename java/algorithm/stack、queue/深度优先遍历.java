import java.util.Stack;

public class DFS {
    /*使用栈实现树的深度优先遍历，首先将根节点放入栈，然后判断栈是否为空，如果不空，就弹出并打印，如果
    右孩子不空，放入右孩子，左孩子不空将左孩子放入栈，循环进行
     */
    public void print(Node root){
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        if(temp!=null){
            stack.push(temp);
        }
        while(!stack.empty()){
            temp = stack.pop();
            System.out.println(temp.getData());
            if(temp.getRight()!=null){
                stack.push(temp.getRight());
            }
            if(temp.getLeft()!=null){
                stack.push(temp.getLeft());
            }
        }
    }
}
