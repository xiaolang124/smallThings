import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BucketSort {
    public static void sort(int[] origin,int maxLen){
        ArrayList<Queue<Integer>> temp = new ArrayList<>();
        for(int i=0;i<10;++i){
            temp.add(new LinkedList<>());
        }
        int t=0;
        int n=0;
        for(int i=0;i<maxLen;++i){
            for(int j=0;j<origin.length;++j){
                t=origin[j]/((int)Math.pow(10,i))%10;
                temp.get(t).add(origin[j]);
            }
            n=0;
            for(int j=0;j<10;++j){
                for(int k=0;k<temp.get(j).size();++k){
                    origin[n]=temp.get(j).poll();
                    ++n;
                }
                temp.get(j).clear();
            }
        }
    }
}
