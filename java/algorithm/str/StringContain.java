public class StringContain {

    public static boolean contain(String a,String b){
        String temp = a+a;
        if(KMP(a,b)>-1){
            return true;
        }else {
            return false;
        }
    }

    public static void next(String str,int[] next,int len){
        //next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
        next[0] = -1;
        //k初始化为-1
        int k = -1;
        for(int q=1;q<len;++q){
            //如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
            while(k>-1&&str.charAt(k+1)!=str.charAt(q)){
                //往前回溯
                k = next[k];
            }
            //如果相同，k++
            if(str.charAt(k+1)==str.charAt(q)){
                k = k+1;
            }
            //这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
            next[q] = k;
        }
    }

    public static int KMP(String str,String ptr){
        int len1 = str.length();
        int len2 = ptr.length();

        int[] next = new int[len2];
        next(ptr,next,len2);
        int k = -1;
        for(int i=0;i<len1;++i){
            //ptr和str不匹配，且k>-1（表示ptr和str有部分匹配）
            while(k>-1&&ptr.charAt(k+1)!=str.charAt(i))
                k = next[k];
            if(ptr.charAt(k+1)==str.charAt(i))
                k=k+1;
            //说明k移动到ptr的最末端
            if(k==len2-1){
                return i-len2+1;
            }
        }
        return -1;
    }
}
