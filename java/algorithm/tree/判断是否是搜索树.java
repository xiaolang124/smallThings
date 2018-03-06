import java.util.ArrayList;
import java.util.Stack;

public class TreeIsSearch {
    //判断是否是搜索二叉树，搜索二叉树左孩子都比当前节点小，右孩子都比当前节点大
    public boolean is(Node head){
        Stack<Node> stack = new Stack<>();
        int num = -999;
        if(head==null){
            return true;
        }
        stack.push(head);
        Node temp = head.getLeft();
        while(!stack.isEmpty()||temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp = temp.getLeft();
            }else {
                temp = stack.pop();
                if(num==-999){
                    num = temp.getData();
                }else {
                    if(temp.getData()>num){
                        num = temp.getData();
                    }else {
                        return false;
                    }
                }
                temp = temp.getRight();
            }
        }
        return true;
    }
}
