public class SubTree {

    //寻找两个树是否有公共部分，先序列化树转成字符串 ，然后KMP比较
    public static boolean find(Node t1,Node t2){
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        String string1 = froTree(t1,stringBuilder1);
        String string2 = froTree(t2,stringBuilder2);
        if(KMP(string1,string2)>0){
            return true;
        }
        return false;
    }

    public static String froTree(Node node,StringBuilder stringBuilder){
        if(node!=null){
            stringBuilder.append(node.getData()+"!");
            froTree(node.getLeft(),stringBuilder);
            froTree(node.getRight(),stringBuilder);
        }else {
            stringBuilder.append("#!");
        }
        return stringBuilder.toString();
    }

    public static void next(String string,int[] next){
        int len = string.length();
        next[0] = -1;
        int k = -1;
        for(int q=1;q<len;++q){
            while(k>-1&&string.charAt(k+1)!=string.charAt(q)){
                k = next[k];
            }
            if(string.charAt(k+1)== string.charAt(q))
                ++k;
            next[q] = k;
        }
    }

    public static int KMP(String s,String p){
        int[] next = new int[p.length()];
        next(p,next);
        int k = -1;
        for(int i=0;i<s.length();++i){
            while(k>-1&&p.charAt(k+1)!=s.charAt(i))
                k = next[k];
            if(p.charAt(k+1)==s.charAt(i))
                ++k;
            if(k==p.length()-1){
                return i-p.length()+1;
            }
        }
        return -1;
    }
}
