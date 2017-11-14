
/*
动态规划
如果 p[j] == str[i] || pattern[j] == '.', 此时dp[i][j] = dp[i-1][j-1];
如果 p[j] == '*'
分两种情况:
1: 如果p[j-1] != str[i] && p[j-1] != '.', 此时dp[i][j] = dp[i][j-2] //*前面字符匹配0次
2: 如果p[j-1] == str[i] || p[j-1] == '.'
	此时dp[i][j] = dp[i][j-2] // *前面字符匹配0次
	或者 dp[i][j] = dp[i][j-1] // *前面字符匹配1次
	或者 dp[i][j] = dp[i-1][j] // *前面字符匹配多次
*/

public static boolean isMatch(String s, String p) {
	int slen = s.length();
	int plen = p.length();
	boolean dp[][] = new boolean[slen+1][plen+1];
	dp[0][0] = true;
	for(int i=1;i<=plen;++i){
		if(p.charAt(i-1)=='*'){
			dp[0][i] = dp[0][i-2];
		}
	}
	
	for(int i=1;i<=slen;++i){
		for(int j=1;j<=plen;++j){
			if(s.charAt(i-1)==p.charAt(j-1)||
					p.charAt(j-1)=='.'){
				dp[i][j] = dp[i-1][j-1];
			}else if(p.charAt(j-1)=='*'){
				if(s.charAt(i-1)!=p.charAt(j-2)&&
						p.charAt(j-2)!='.'){
					//匹配*前面的字符0次
					dp[i][j] = dp[i][j-2];
				}else{
					//*前面字符匹配1次 || *前面字符匹配0次 || *前面字符匹配多次
					dp[i][j] = dp[i][j-1]||
							dp[i][j-2]||
							dp[i-1][j];
				}
			}
		}
	}
	
	return dp[slen][plen];
}