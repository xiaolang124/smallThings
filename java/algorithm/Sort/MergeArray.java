public class MergeArray {

    //合并两个有序数组到第一个数组，从后向前运行
    public static void merge(int[] a,int[] b,int lenA){
        int k = a.length-1;
        int m = lenA-1;
        int n = b.length-1;
        while(m>=0&&n>=0){
            if(a[m]>b[n]){
                a[k] = a[m];
                --m;
            }else {
                a[k] = b[n];
                --n;
            }
            --k;
        }
        while(n>=0){
            a[k] = b[n];
            --n;
            --k;
        }
    }
}
