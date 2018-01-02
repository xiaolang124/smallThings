import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FindSubstring {
    /*
    You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

    For example, given:
    S:"barfoothefoobarman"
    L:["foo", "bar"]

    You should return the indices:[0,9].
    匹配字符串中完全出现了给定单词组的起始位置，每次匹配一个单词，匹配到了进行边界判断等，没匹配到重新匹配。
    index：开始匹配位置
    j：正在匹配位置
    temp：正在匹配单词
    i：开始匹配的字符串位置
    */
    public static ArrayList<Integer> find(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<>();
        if(S==null||S.length()==0||L==null||L.length==0)
            return result;

        HashMap<String,Integer> dict = new HashMap<>();
        int len = L[0].length();
        for(String word:L){
            if(dict.containsKey(word)){
                dict.put(word,dict.get(word)+1);
            }else {
                dict.put(word,1);
            }
        }

        for(int i=0;i<len;++i){
            int count = 0;
            int index = i;
            HashMap<String,Integer> hashMap = new HashMap<>();
            for(int j=i;j<=S.length()-len;j+=len){
                String temp = S.substring(j,j+len);
                if(dict.containsKey(temp)){
                    if(hashMap.containsKey(temp)){
                        hashMap.put(temp,hashMap.get(temp)+1);
                    }else {
                        hashMap.put(temp,1);
                    }
                    if(hashMap.get(temp)<=dict.get(temp)){
                        ++count;
                    }else {
                        while(hashMap.get(temp)>dict.get(temp)){
                            String s = S.substring(index,index+len);
                            hashMap.put(s,hashMap.get(s)-1);
                            if(hashMap.get(s)<dict.get(s))
                                --count;
                            index = index+len;
                        }
                    }
                    if(count==L.length){
                        result.add(index);
                        String s1 = S.substring(index,index+len);
                        hashMap.put(s1,hashMap.get(s1)-1);
                        index = index+len;
                        --count;
                    }
                }else {
                    hashMap.clear();
                    count = 0;
                    index = j+len;
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}