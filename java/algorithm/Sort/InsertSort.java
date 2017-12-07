public class InsertSort {
    public static void sort(int[] origin){
        int len = origin.length;
        int temp;
        for(int i=1;i<len;++i){
            for(int j=i;j>=1;--j){
                if(origin[j]<origin[j-1]){
                    temp = origin[j];
                    origin[j] = origin[j-1];
                    origin[j-1] =temp;
                }else {
                    break;
                }
            }
        }

        for(int i=0;i<len;++i){
            System.out.println(origin[i]);
        }
    }
}
