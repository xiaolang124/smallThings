import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void print(Node root){
        Queue<Node> queue = new LinkedList<>();
        Node temp = root;
        if(temp!=null){
            queue.add(temp);
        }
        while(queue.size()>0){
            temp = queue.poll();
            System.out.println(temp.getData());
            if(temp.getLeft()!=null){
                queue.add(temp.getLeft());
            }
            if(temp.getRight()!=null){
                queue.add(temp.getRight());
            }
        }
    }
}
