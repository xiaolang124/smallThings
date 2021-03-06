import java.util.LinkedList;
import java.util.Queue;

public class TreePrintByRow {
    public static void print(Node root){
        Node rEnd = null;
        Node now = null;

        Queue<Node> temp = new LinkedList<>();
        System.out.println(root.getData());
        if(root.getLeft()!=null){
            temp.add(root.getLeft());
            rEnd = root.getLeft();
        }
        if(root.getRight()!=null){
            temp.add(root.getRight());
            rEnd = root.getRight();
        }

        while (!temp.isEmpty()){
            now = temp.poll();
            System.out.print(now.getData() + " ");
            if(now == rEnd){
                System.out.println();
                if(now.getLeft()!=null){
                    temp.add(now.getLeft());
                    rEnd = now.getLeft();
                }
                if(now.getRight()!=null){
                    temp.add(now.getRight());
                    rEnd = now.getRight();
                }
            }else {
                if(now.getLeft()!=null){
                    temp.add(now.getLeft());
                }
                if(now.getRight()!=null){
                    temp.add(now.getRight());
                }
            }
        }
    }
}