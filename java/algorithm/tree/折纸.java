import java.util.ArrayList;

public class TreeFold {
    /*
    依次从下向上折叠n次纸，然后展开，从上到下打印折痕
     */
    public ArrayList<String> fold(int n){
        ArrayList<String> result = new ArrayList<>();
        if(n<1)
            return result;
        ReInOrder(n-1,1,result);
        result.add("down");
        ReInOrder(n-1,0,result);
        return result;
    }

    public void ReInOrder(int n,int flag,ArrayList<String> result){
        if(n<1)
            return;
        ReInOrder(n-1,1,result);
        if(flag==1)
            result.add("down");
        else
            result.add("up");
        ReInOrder(n-1,0,result);
    }
}
