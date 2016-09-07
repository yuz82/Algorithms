/**
给一个数字组成的字符串，输出所有用'+'和'-'组成的表达式：
比如输入： 123
输出：
1 + 2 + 3
1 + 2 - 3. from: 1point3acres.com/bbs 
-1 + 2 - 3. more info on 1point3acres.com
-123
123
....

*/

static List<String> res = new ArrayList<>();
	public static List<String> Solution(String s) {
		if(s==null || s.length()==0){ return res; }
		StringBuilder sb = new StringBuilder();
        helper(s, 0, sb);
        return res;
    }
	
	public static void helper(String s, int i, StringBuilder sb){
		if(i==s.length()){
			res.add(sb.toString()); return;
		}
		sb.append(s.charAt(i));
		helper(s, i+1, sb);
		
		sb.insert(sb.length()-1, '-');
		helper(s, i+1, sb);
		sb.deleteCharAt(sb.length()-2);
		if(sb.length()>1) { 
			sb.insert(sb.length()-1, '+'); 
			helper(s, i+1, sb);
			sb.deleteCharAt(sb.length()-2);
		}
		sb.deleteCharAt(sb.length()-1);
	}
