package hard.encode_string_471;

import java.util.Stack;

public class Solution {
	public static String encode1(String s) {
		if (s.length() <= 4) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		Stack<Character> prev = new Stack<>();
		int count = 1;int index =0;
		do {
		char currChar = s.charAt(index);
			if(!prev.isEmpty()) {
				Character prevChar = prev.pop();
				if(prevChar == currChar) {
					count ++;
				}else {
					String str =( count == 1)?(prevChar + "[" + count +"]") : (Character.toString(prevChar));
					sb.append(str);
					count = 1;prev.clear();
				}
			}
			prev.push(currChar);
			index ++;
		}while(!prev.isEmpty() && index < s.length());
		
		return sb.toString();

	}

	public static String encode(String s) {
		// baaaacca => b4[a]
		// aaabca => 3[a]bca
		// currChar =
		char prevChar = ' ';
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (char currChar : s.toCharArray()) {
			if (prevChar == currChar) {
				count++;
			} else if (prevChar != ' ') {
				sb.append(prevChar);
				if (count != 1) {
					sb.append('[');
					sb.append(count);
					sb.append(']');
				}
				count = 1;
			}

			prevChar = currChar;
		}
		sb.append(prevChar);
		if (count != 1) {
			sb.append('[');
			sb.append(count);
			sb.append(']');
		}
		return (sb.toString().length() <= s.length()) ? sb.toString() : s;
	}

	public static void main(String[] args) {
		// System.out.println(encode("aaaaaabbbccccccccccaaaa"));
		// System.out.println(encode("aaaaaaaaaa"));
		long currentTimeMillis = System.currentTimeMillis();
		//System.out.println(encode("aabcaabcd"));
		System.out.println(encode1("aabcaabcd"));
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
		;
	}
}