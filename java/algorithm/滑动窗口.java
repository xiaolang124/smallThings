Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


/*
    "��������" 
    �ȷ�˵ abcabccc �����ұ�ɨ�赽abca��ʱ����ðѵ�һ��aɾ���õ�bca��
    Ȼ��"����"�������һ�����ÿ���ӵ�һ����char��ʱ����߼�������ظ���char��
    Ȼ�����û���ظ��ľ�������ӣ�
    ���ظ��Ļ�������ӵ�һ���֣��������ظ�char����ӵ���������������м�¼��󴰿ڳ���
*/

public int lengthOfLongestSubstring(String s) {
	if(s==null||s.length()==0)
		return 0;
	HashMap<Character, Integer> chs = new HashMap<Character, Integer>();
	int leftBound=0;
	int max=0;
	for(int i=0;i<s.length();++i){
		char c=s.charAt(i);
		leftBound=Math.max(leftBound, chs.containsKey(c) chs.get(c)+1:0);
		max=Math.max(max, i-leftBound+1);
		chs.put(c,i);
	}
	return max;
}