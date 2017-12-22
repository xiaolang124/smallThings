public class SwitchString {

    public static String switchString(String str,int pos){
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length-1);
        reverse(chars,0,pos-1);
        reverse(chars,pos,chars.length-1);
        StringBuilder result = new StringBuilder();
        for(int i=0;i<str.length();++i){
            result.append(chars[i]);
        }
        return result.toString();
    }

    public static void reverse(char[] chars,int start,int end){
        int i = start;
        int j = end;
        while(i<j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            ++i;
            --j;
        }
    }
}
