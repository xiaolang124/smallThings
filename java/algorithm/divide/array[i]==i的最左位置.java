public class DivideFindI {
    //给定一个有序数组array，其中不含有重复元素，请找到满足array[i]==i的最左位置，如果没有返回-1
    public int find(int[] array){
        int len = array.length;
        if(len==0||array[0]>len-1||
                array[len-1]<0)
            return -1;
        int res = -1;
        int low = 0, high = len-1, mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(array[mid]<mid)
                low = mid + 1;
            else if(array[mid]>mid)
                high = mid - 1;
            else {
                res = mid;
                high = mid-1;
            }
        }
        return res;
    }
}
