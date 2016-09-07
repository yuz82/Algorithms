/**
给一个String, 如AABACCDCD, 插入'_'使同一个字母间隔为k: 如果k=3: A___AB__AC___CD__CD, 
一开始理解有误，认为是要先shuffle字母顺序然后插入'_'，花了不少时间，
然后面试官提示字母顺序不变，写出来，然后直接run出来有bug，在coderpad上调了一会才通过。。。
*/

//AABACCDCD k = 3
	public static String Solution(String s, int k) {
		if(s==null || s.length()<2) { return s; }
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(s.charAt(i));
			int idx = getNext(s, i, k);
			if(idx==-1) { continue; }
			//ab--a
			for(int j=0;j<=k-idx+i;j++){
				sb.append("_");
			}
		}
		return sb.toString();
    }
	
	public static int getNext(String s, int i, int k){
		for(int t=1;t<=k;t++){
			if(i+t<s.length() && s.charAt(i+t)==s.charAt(i)){
				return i+t;
			}
		}
		return -1;
	}
