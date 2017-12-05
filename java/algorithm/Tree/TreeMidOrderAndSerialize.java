import java.util.Stack;

public class TreeMidOrderAndSerialize {

    public static void midOrder(Node root){
        if(root != null){
            midOrder(root.getLeft());
            System.out.println(root.getData());
            midOrder(root.getRight());
        }{
            return;
        }
    }

    public static void midOrderNoRecursive(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while(!stack.isEmpty()||
                temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp = temp.getLeft();
            }else {
                temp = stack.pop();
                System.out.println(temp.getData());
                temp = temp.getRight();
            }
        }
    }
}
