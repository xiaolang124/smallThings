public class DivideFindLeft {
    //查找有序数组中特定值出现的最左位置
    public int find(int[] array,int target){
        int len = array.length;
        if(len==0){
            return -1;
        }
        int left = 0, right = len - 1;
        int mid, result = -1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(array[mid]<target)
                left = mid + 1;
            else if(array[mid]>target)
                right = mid - 1;
            else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}
