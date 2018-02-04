public class DivideLessIndex {
    /*
    给定一个数组，已知相邻两个元素不重复，返回局部最小位置。
    局部最小位置，如果array[0]<array[1]，0就是，如果array[n-1]<array[n-2]，n-1位置就是，
    否则只要有一个位置i，满足array[i]<array[i-1]并且array[i]<array[i+1]，i就是局部最小位置。
     */
    public int index(int[] array){
        if(array.length==0){
            return -1;
        }
        if(array.length==1){
            return 0;
        }
        if(array[0]<array[1]){
            return 0;
        }
        int len = array.length;
        if(array[len-1]<array[len-2])
            return len-1;
        int left = 0;
        int right = len - 1;
        int middle = left + (right-left)/2;
        while(array[middle]>array[right]||
                array[middle]>array[left]){
            if(array[middle]>array[right]){
                left = middle + 1;
                middle = left + (right-left)/2;
            }else {
                right = middle - 1;
                middle = left + (right-left)/2;
            }
        }
        return middle;
    }

}
