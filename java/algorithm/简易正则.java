
/*
��̬�滮
��� p[j] == str[i] || pattern[j] == '.', ��ʱdp[i][j] = dp[i-1][j-1];
��� p[j] == '*'
���������:
1: ���p[j-1] != str[i] && p[j-1] != '.', ��ʱdp[i][j] = dp[i][j-2] //*ǰ���ַ�ƥ��0��
2: ���p[j-1] == str[i] || p[j-1] == '.'
	��ʱdp[i][j] = dp[i][j-2] // *ǰ���ַ�ƥ��0��
	���� dp[i][j] = dp[i][j-1] // *ǰ���ַ�ƥ��1��
	���� dp[i][j] = dp[i-1][j] // *ǰ���ַ�ƥ����
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
					//ƥ��*ǰ����ַ�0��
					dp[i][j] = dp[i][j-2];
				}else{
					//*ǰ���ַ�ƥ��1�� || *ǰ���ַ�ƥ��0�� || *ǰ���ַ�ƥ����
					dp[i][j] = dp[i][j-1]||
							dp[i][j-2]||
							dp[i-1][j];
				}
			}
		}
	}
	
	return dp[slen][plen];
}