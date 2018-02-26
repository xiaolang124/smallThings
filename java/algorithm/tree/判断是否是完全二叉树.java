import java.util.LinkedList;
import java.util.Queue;

public class TreeIsComplete {
    //判断是否是完全二叉树
    /*
    1、采用按层遍历二叉树，从每层的 左边向右边遍历
    2、如果当前结点有右孩子，但没有左孩子，返回false
    3、如果当前节点不是左右孩子都有，那之后的节点都必须为叶节点，否则返回false
    4、遍历过程中如果不返回false，遍历结束后返回true
     */
    public boolean isComplete(Node head){
        Queue<Node> queue = new LinkedList<>();
        if(head==null){
            return true;
        }
        queue.add(head);
        Node temp;
        boolean flag = false;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(flag!=true){
                if(temp.getLeft()==null&&
                        temp.getRight()!=null)
                    return false;
                if(temp.getLeft()!=null){
                    queue.add(temp.getLeft());
                    if(temp.getRight()!=null){
                        queue.add(temp.getRight());
                    }
                }else {
                    flag = true;
                }
            }else {
                if(temp.getLeft()!=null||temp.getRight()!=null)
                    return false;
            }
        }
        return true;
    }
}
