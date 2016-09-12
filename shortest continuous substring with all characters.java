/**
input : aabbc
output: abbc
*/

//solution 1
public static String Solution(String s) {
		if(s==null) {
			return "";
		}
		int[] arr = new int[128];
		int count = 0;
		for(char c : s.toCharArray()){
			if(arr[c]==0){
				++arr[c];
				++count;
			}
		}
		int begin = 0, end = 0, head = 0, len = Integer.MAX_VALUE;
		while(end < s.length()){
			if(arr[s.charAt(end++)]-->0){
				--count;
			}
			while(count==0){
				if(end-begin<len){
					len = end - begin;
					head = begin;
				}
				if(arr[s.charAt(begin++)]++==0){
					++count;
				}
			}
		}
		return len==Integer.MAX_VALUE ? "" : s.substring(head, head+len);
    }
