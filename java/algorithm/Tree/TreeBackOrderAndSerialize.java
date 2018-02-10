import java.util.Stack;

public class TreeBackOrderAndSerialize {

    public static void backOrder(Node root){
        if(root==null){
            return;
        }else{
            backOrder(root.getLeft());
            backOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public static void backOrderNoRecursive(Node root){
        if(root==null)
            return;
        Stack<Node> stack = new Stack<>();
        Node now,last;
        now = root;
        last = null;
        while(now!=null){
            stack.push(now);
            now = now.getLeft();
        }
        while(!stack.isEmpty()){
            now = stack.pop();
            if(now.getRight()==null ||
                    now.getRight()==last){
                System.out.println(now.getData());
                last = now;
            }else{
                stack.push(now);
                now = now.getRight();
                while(now!=null){
                    stack.push(now);
                    now = now.getLeft();
                }
            }
        }
    }
    
    public static void backOrder(Node root){
        if(root==null)
            return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        Node temp;
        while(!s1.isEmpty()){
            temp = s1.pop();
            s2.push(temp);
            if(temp.getLeft()!=null) {
                s1.push(temp.getLeft());
            }
            if(temp.getRight()!=null){
                s1.push(temp.getRight());
            }
        }
        while(!s2.isEmpty()){
            System.out.println(s2.pop().getData());
        }
    }

}
