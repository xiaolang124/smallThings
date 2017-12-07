public class ChooseSort {

    public static void sort(int[] origin){
        int temp;
        int pos;
        int len = origin.length;
        for(int i=0;i<len;++i){
            temp=Integer.MAX_VALUE;
            pos=Integer.MAX_VALUE;
            for(int j=len-1;j>=i;--j){
                if(temp>origin[j]){
                    temp = origin[j];
                    pos = j;
                }
            }
            if(pos!=i&&pos!=Integer.MAX_VALUE){
                origin[pos]=origin[i];
                origin[i]=temp;
            }
        }

        for(int i=0;i<len;++i){
            System.out.println(origin[i]);
        }
    }
}
