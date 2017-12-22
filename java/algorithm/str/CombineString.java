public class CombineString {

    public static String combine(String[] strings){
        if(strings.length==0){
            return null;
        }
        if(strings.length==1){
            return strings[0];
        }

        String result = "";
        String first = null;
        String second = null;

        for(int i=0;i<strings.length;++i){
            first = result+strings[i];
            second = strings[i]+result;
            if(first.compareTo(second)<0){
                result = first;
            }else {
                result = second;
            }
        }

        return result;
    }
}
