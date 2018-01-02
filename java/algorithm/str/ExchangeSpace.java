public class ExchangeSpace {
	//替换空格为20%，从后向前
    public static char[] exchange(char[] temp){
        int len = temp.length;
        for(int i=0;i<temp.length;++i){
            if(temp[i]==' '){
                len += 2;
            }
        }
        char[] result = new char[len];
        int k = len-1;
        for(int i=temp.length-1;i>=0;--i){
           if(temp[i]!=' '){
                result[k] = temp[i];
                k -= 1;
           }else {
               result[k] = '%';
               result[k-1] = '0';
               result[k-2] = '2';
               k -= 3;
           }
        }
        return result;
    }
}
