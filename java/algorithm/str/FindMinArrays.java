public class FindMinArrays {

    //找到数组中需要排序的最小数组，从左向右找当前最大值，如果之前的大于本值，记录当前位置
    //记录最右侧位置，从右向左找当前最小值，小于本值，记录位置，求位置差
    public static int find(int[] arrays){
        int max = arrays[0];
        int min = arrays[arrays.length-1];
        int right = 0;
        int left  = 0;
        for(int i=1;i<arrays.length;++i){
            if(max<arrays[i]){
                max = arrays[i];
            }else{
                right = i;
            }
        }

        for(int i=arrays.length-2;i>=0;--i){
            if(min>arrays[i]){
                min = arrays[i];
            }else{
                left = i;
            }
        }

        return right-left+1;
    }
}
