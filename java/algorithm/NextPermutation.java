public class NextPermutation {
//找到比当前数组大的下一个数组，如果没有，返回最小数组
//从后向前找到升序位置i，从后往前找到比i-1位置大的j，调换i与j，逆序i到末尾
    public static void find(int[] num){
        if(num.length<=1)
            return;
        int i = num.length-1;
        while(i>0&&num[i]<=num[i-1])
            --i;
        if(i==0){
            reverse(num,0,num.length-1);
        }else {
            int j = num.length-1;
            while(num[j]<=num[i-1])
                --j;
            swap(num,i-1,j);
            reverse(num,i,num.length-1);
        }
    }

    public static void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void reverse(int[] num,int start,int end){
        int temp;
        while(start<end){
            temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            ++start;
            --end;
        }
    }

}
