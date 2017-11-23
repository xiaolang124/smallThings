//先对字符串排序，然后考虑第一个和最后一个的首字符，这两个字符必定是差距最大的两个
//(因为排序首先从第一个开始排)，如果这两个不等，就返回空，否则，说明所有字符串的首
//字符相等，那么接着判断第二个。

import java.lang.Math;
import java.util.*;
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        Arrays.sort(strs);
        int i=0,len = strs.length;
        int l = Math.min(strs[0].length(),strs[len-1].length());
        for(;i<l;++i){
            if(strs[0].charAt(i)!= strs[len-1].charAt(i)){
                return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,l);
    }
}
