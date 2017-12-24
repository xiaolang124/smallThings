public class HollandQuestion {

    //荷兰国旗问题 。只包含0，1，2的整数数组进行排序
    public static void sort(int[] origin){
        int start = 0;
        int end = origin.length-1;
        for(int i=0;i<=end;++i){
            if(origin[i]==1)
                continue;
            else if(origin[i]==0){
                swap(origin,i,start);
                ++start;
            }else if(origin[i]==2){
                swap(origin,i,end);
                --end;
                //与2区域调换之后当前位置还没做过判断，需要再次判断
                --i;
            }
        }
    }

    public static void swap(int[] origin,int a,int b){
        int temp = origin[a];
        origin[a] = origin[b];
        origin[b] = temp;
    }
}
