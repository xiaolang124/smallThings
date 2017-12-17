public class QuickSort {

    public static void sort(int[] origin){
        quickSort(origin,0,origin.length-1);

    }

    public static void quickSort(int[] origin, int begin, int end){
        int i,j,t,temp;
        if(begin>end){
            return;
        }

        temp = origin[begin];
        i = begin;
        j = end;
        while(i!=j){
            while(origin[j]>=origin[begin]&&i<j){
                --j;
            }
            while(origin[i]<=origin[begin]&&i<j){
                ++i;
            }
            if(i<j){
                t = origin[i];
                origin[i] = origin[j];
                origin[j] = t;
            }
        }
        origin[begin] = origin[i];
        origin[i] = temp;
        quickSort(origin,begin,i-1);
        quickSort(origin,i+1,end);
    }
}
