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

    /*
    1、申请一个栈，记为stack，将头节点压入stack，同时设置两个变量h和c。在整个流程中，h代表最近一次弹出并打印的节点，c代表当前stack的栈顶节点，初始时令h为头节点，c为null。
    2、每次令c等于当前stack的栈顶节点，但是不从stack中弹出节点，分以下三种情况。
    （1）如果c的左孩子不为空，并且h不等于c的左孩子，也不等于c的右孩子，则把c的左孩子压入stack中。
    （2）如果情况1不成立，并且c的右孩子不为空，并且h不等于c的右孩子，则把c的右孩子压入stack中。
    （3）如果情况1、2都不成立，那么从stack中弹出c并打印，然后令h等于c。
    */
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
    
    /*
    1、申请一个栈，记为s1，将头节点压入s1中。
    2、从s1中弹出的节点记为cur，然后把cur的左孩子压入s1中，然后把cur的右孩子压入s1中。
    3、每一个从s1中弹出的节点都放入第二个栈s2中。
    */
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
