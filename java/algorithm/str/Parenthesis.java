public class Parenthesis {
	//左右括号是否出现正常
    public static boolean check(String str){
        int temp = 0;
        for(int i=0;i<str.length();++i){
            if(str.charAt(i)=='('){
                ++temp;
            }else if(str.charAt(i)==')'){
                --temp;
                if(temp<0){
                    return false;
                }
            }
        }
        if(temp==0){
            return true;
        }else {
            return false;
        }
    }
}
