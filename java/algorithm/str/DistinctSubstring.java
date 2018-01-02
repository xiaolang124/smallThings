import java.util.HashMap;

public class DistinctSubstring {

    //找字符串中出现的最长无重复字串
	//通过hashmap、上一个位置最长无重复字串长度来确定
    public static int find(String str){
        int len = str.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int pre = 0;
        int[] array = new int[len];
        char c;
        for(int i=0;i<len;++i){
            c = str.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c)>=(i-pre)){
                    array[i] = i-map.get(c);
                }else {
                    array[i] = pre+1;
                }
            }else {
                array[i] = pre+1;
            }
            pre = array[i];
            map.put(c,i);
        }
        int result = 0;
        for(int i=1;i<len;++i){
            if(array[i]>result)
                result = array[i];
        }
        return result;
    }
}
