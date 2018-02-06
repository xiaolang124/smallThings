public class DivideFindMin {
    //有序循环数组：有序数组左边任意长度的部分放到右边去形成的，寻找该数组最小值
    public int find(int[] array){
        if(array.length==0){
            return -1;
        }
        int len = array.length;
        if(len==1||array[0]<array[len-1])
            return 0;
        int low = 0, high = len-1, mid;
        while(low<high){
            mid = low + (high-low)/2;
            if(array[low]>array[mid])
                high =  mid;
            else if(array[mid]>array[high])
                low = mid + 1;
            else
                break;
        }
        if(low==high)
            return low;
        int min = low;
        while(low<=high){
            if(array[low]<array[low])
                min = low;
            ++low;
        }
        return low;
    }
}
