public class MergeSort {
    public static void merge(int[] origin,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(origin[i]<=origin[j]){
                temp[t++] = origin[i++];
            }else {
                temp[t++] = origin[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = origin[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = origin[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            origin[left++] = temp[t++];
        }
    }

    public static void merge_sort(int[] origin,int left,int right,int[] temp){
        if(left<right){
            int  mid = (left+right)/2;
            merge_sort(origin,left,mid,temp);
            merge_sort(origin,mid+1,right,temp);
            merge(origin,left,mid,right,temp);
        }
    }

    public static void sort(int[] origin){
        int[] temp = new int[origin.length];
        merge_sort(origin,0,origin.length-1,temp);

        for(int i=0;i<origin.length;++i){
            System.out.println(origin[i]);
        }
    }
}
