Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


/*
    "滑动窗口" 
    比方说 abcabccc 当你右边扫描到abca的时候你得把第一个a删掉得到bca，
    然后"窗口"继续向右滑动，每当加到一个新char的时候，左边检查有无重复的char，
    然后如果没有重复的就正常添加，
    有重复的话就左边扔掉一部分（从最左到重复char这段扔掉），在这个过程中记录最大窗口长度
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