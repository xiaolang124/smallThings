import java.util.Arrays;

public class ReverseString {

    public static String reverse(String str){
        int len = str.length();
        char[] chars = str.toCharArray();
        int start = 0;
        int end = len-1;
        while(start<end){
            swap(chars,start,end);
            ++start;
            --end;
        }

        start = 0;
        int k = 0;
        while (k<len){
            while(k<len&&chars[k]!=' '){
                ++k;
                continue;
            }
            end = k-1;
            while(start<end){
                swap(chars,start,end);
                ++start;
                --end;
            }
            start = k+1;
            ++k;
        }
        return Arrays.toString(chars);
    }

    public static void swap(char[] chars,int a,int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
