import java.util.HashMap;

public class DeformableWord {
    //给定两个字符串str1和str2，如果str1和str2出现的字符种类一样切每种
    //字符出现的次数一样，互为变形词
    //可以使用哈希表，也可以使用定长数组
    public static boolean deformable(String str1,String str2){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        System.out.println(hashMap.size());
        char c;
        for(int i=0;i<str1.length();++i){
            c = str1.charAt(i);
            if(hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c)+1);
            }else {
                hashMap.put(c,1);
            }
        }

        for(int i=0;i<str2.length();++i){
            c = str2.charAt(i);
            if(hashMap.containsKey(c)){
                if(hashMap.get(c)==1){
                    hashMap.remove(c);
                }else {
                    hashMap.put(c,hashMap.get(c)-1);
                }
            }else {
                return false;
            }
        }

        if(hashMap.size()==0){
            return true;
        }else {
            return true;
        }
    }
}
