import java.util.*;

public class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        int[] keys = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] values = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<keys.length;++i){
            map.put(values[i],keys[i]);
        }
        int i = 0 ;
        int len = s.length();
        int re = 0;
        String temp = null;
        while(i<len-1){
            if(map.get(s.substring(i,i+1))<
                    map.get(s.substring(i+1,i+2))){
                temp =s.substring(i,i+2) ;
                i += 2;
            }else{
                temp = s.substring(i,i+1);
                ++i;
            }
            re += map.get(temp);
        }
        if(i<len){
            re += map.get(s.substring(i,i+1));
        }

        return re;
    }
}
