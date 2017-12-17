public class HeapSort {

    public static void sort(int[] origin){
		// 循环建立初始堆
        for(int i=origin.length/2;i>=0;--i){
            heapAdjust(origin,i,origin.length);
        }
        for(int i=origin.length-1;i>0;--i){
            int temp = origin[i];
            origin[i] = origin[0];
            origin[0] = temp;

            heapAdjust(origin,0,i);
        }
    }

    public static void heapAdjust(int[] origin,int parent,int len){
        int temp = origin[parent];
        int child = 2*parent+1;
        while(child<len){
            if(child+1<len&&origin[child]<origin[child+1]){
                ++child;
            }
            if(temp>=origin[child]){
                break;
            }
            origin[parent] = origin[child];
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2*child+1;
        }
        origin[parent] = temp;
    }
}
