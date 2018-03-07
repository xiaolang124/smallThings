public class TreeOrderFind {
    //搜索二叉树的中序遍历有两个数错位，请找出，先打印小的值
    //1、两次降序，第一个错误节点是第一次中较大的，第二次中较小的
    //2、一次降序，第一个为较大的，第二个为较小的
    public void find(int[] array){
        int temp = -1;
        int pos = 0;
        for(;pos<array.length-1;++pos){
            if(array[pos]>array[pos+1]){
                if(temp!=-1){
                    if(array[pos+1]<array[temp]){
                        System.out.println(array[pos+1]);
                        System.out.println(array[temp]);
                    }else {
                        System.out.println(array[temp]);
                        System.out.println(array[pos+1]);
                    }
                    break;
                }else {
                    temp = pos;
                }
            }
        }
        if(pos==array.length-1){
            System.out.println(array[temp+1]);
            System.out.println(array[temp]);
        }
    }
}
