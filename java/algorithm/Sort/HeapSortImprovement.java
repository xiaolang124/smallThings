public class HeapSortImprovement {

    //已知一个几乎有序数组，几乎有序指，如果把数组排好顺序的话，每个元素移动的距离不超过k，
    //并且k相对于数组长度很小，请问选择什么排序较好
    //改进的堆排序，堆的大小为k，堆顶最小，不断弹出放在数组头，然后增加一个数，不断循环
    public static void sort(int[] origin,int k){
        //初始化堆
        int[] temp = new int[k];
        for(int i=0;i<k;++i) {
            temp[i] = origin[i];
        }
        for(int i=k/2;i>=0;--i){
            headAdjust(temp,i,k);
        }
        origin[0] = temp[0];
        //后续加入堆顶的原数组位置
        int m = k;
        //返回结果的数组位置
        int pos = 1;
        while(m<origin.length){
            temp[0] = origin[m];
            headAdjust(temp,0,k);
            origin[pos] = temp[0];
            ++pos;
            ++m;
        }

        for(int i=1;i<k;++i){
            origin[pos] = temp[i];
            ++pos;
        }
    }

    //调整堆
    public static void headAdjust(int[] origin,int parent,int len){
        int child = parent*2+1;
        int temp = origin[parent];
        while(child<len){
            if(child+1<len&&origin[child]>origin[child+1]){
                child += 1;
            }
            if(origin[child]>origin[parent])
                break;

            origin[parent] = origin[child];
            parent = child;
            child = 2*parent+1;
        }
        origin[parent] = temp;
    }
}
