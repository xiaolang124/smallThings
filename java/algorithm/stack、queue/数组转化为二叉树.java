import java.util.ArrayList;
import java.util.Stack;

public class IntToTree {
    //数组转化为二叉树，寻找左边第一个比他大的树，以及右边第一个比他大的数，较小的作为父节点，
    //如果有一个没有，另一个为父节点，两个都没有，为跟节点
    public int[] change(int[] from){
        int len = from.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        int[] right = new int[len];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<len;++i){
            while(!stack.isEmpty()&&
                    from[stack.peek()]<=from[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for(int i=len-1;i>=0;--i){
            while(!stack.isEmpty()&&
                    from[stack.peek()]<=from[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = -1;
            }else {
                right[i] = stack.pop();
            }
            stack.push(i);
        }
        //构建树
        for(int i=0;i<len;++i){
            if(right[i]==-1&&left[i]==-1){
                res.add(-1);
            }else if(right[i]==-1||left[i]==-1){
                res.add(right[i]>left[i]?right[i]:left[i]);
            }else {
                if(from[right[i]]>from[left[i]])
                    res.add(left[i]);
                else
                    res.add(right[i]);
            }
        }
        int[] result = new int[len];
        for(int i=0;i<len;++i){
            result[i] = res.get(i);
        }
        return result;
    }
}
