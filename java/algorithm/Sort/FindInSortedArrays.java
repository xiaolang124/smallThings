public class FindInSortedArrays {

    //二位数组每行、每列有序，查找某值是否存在二维在数组中
    public static boolean find(int[][] arrays,int target){
        int row = 0;
        int column = arrays[0].length-1;
        while(row<arrays.length&&column>=0){
            if(arrays[row][column]>target){
                --column;
            }else if(arrays[row][column]<target){
                ++row;
            }else {
                return true;
            }
        }
        return false;
    }
}
