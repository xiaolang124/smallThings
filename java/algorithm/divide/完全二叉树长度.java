public class DivideAllTreeLength {
    //给定一棵玩完全二叉树头结点head，返回这棵树的节点个数。
    public int count(Node head){
        if(head==null)
            return 0;
        int lengthOfLeft = depthOfTree(head.getLeft());
        int lengthOfRight = depthOfTree(head.getRight());
        if(lengthOfLeft==lengthOfRight){
            return (int)Math.pow(2,lengthOfLeft) + count(head.getRight());
        }else {
            return (int)Math.pow(2,lengthOfRight) + count(head.getLeft());
        }
    }

    int depthOfTree(Node root){
        if(root==null)
            return 0;
        Node p = root;
        int len = 0;
        while(p!=null){
            ++len;
            p = p.getLeft();
        }
        return len;
    }
}
