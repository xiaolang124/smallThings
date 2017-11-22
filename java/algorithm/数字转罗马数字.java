//Given an integer, convert it to a roman numeral.

import java.util.*;

public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        int[] keys = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] values = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<keys.length;++i){
            map.put(keys[i],values[i]);
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<keys.length;++i){
            int count = num/keys[i];
            for(int j=0;j<count;++j){
                result.append(map.get(keys[i]));
            }
            num %= keys[i];
        }
        return result.toString();
    }
}
