public class BubbleSort {

    public static void sort(int[] origin){
        int len = origin.length;
        int temp = 0;
        for(int i=0;i<len-1;++i){
            for(int j=len-1;j>i;--j){
                if(origin[j]<origin[j-1]){
                    temp = origin[j-1];
                    origin[j-1] = origin[j];
                    origin[j] = temp;
                }
            }
        }
        for(int i=0;i<len;++i){
            System.out.println(origin[i]);
        }
    }
}
