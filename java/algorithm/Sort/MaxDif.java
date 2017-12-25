import java.util.ArrayList;
import java.util.Arrays;

public class MaxDif {

    //给定一个整型数组，返回数组排序后，相邻最大差值，通过桶排序，找到相邻桶之间差值
    public static int find(int[] origin){
        int  min = Integer.MAX_VALUE;
        int  max = Integer.MIN_VALUE;
        for(int i=0;i<origin.length;++i){
            if(origin[i]<min){
                min = origin[i];
            }
            if(origin[i]>max){
                max = origin[i];
            }
        }

        float step = (float)(1.0*(max-min)/origin.length);
        int j;
        int[][] arrays = new int[origin.length+1][2];
        for(int i=0;i<origin.length;++i){
            j = (int)((origin[i]-min)/step);
            if(arrays[j][0]==0){
                arrays[j][0] = origin[i];
                arrays[j][1] = origin[i];
            }else {
                if(arrays[j][0]>origin[i])
                    arrays[j][0] = origin[i];
                if(arrays[j][1]<origin[i])
                    arrays[j][1] = origin[i];
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=j=0;i<origin.length;i=j){
            while(arrays[i][0]==0)
                ++i;
            max = arrays[i][1];
            j = i+1;
            if(j<origin.length+1){
                while(j<origin.length+1&&arrays[j][0]==0)
                    ++j;
                if(j>=origin.length+1)
                    break;
                min = arrays[j][0];
                if(min-max>result)
                    result = min-max;
            }
        }
        return result;
    }
}
