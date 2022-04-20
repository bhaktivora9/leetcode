package medium.reverse_words_151;

public class Solution {
	public static String reverseWords(String s) {
		String[] split = s.split(" ");
		String ans = "";
		for(int i = split.length-1;i>=0;i--) {
			String string = split[i];
			if(!string.isBlank()) ans = ans + string+" ";
		}
		return ans;

	}

	/*
	 * String reverse(String[] str){ }
	 */

	public static void main(String[] args) {
		System.out.println(reverseWords("  hello world  "));
		System.out.println(reverseWords("a good   example"));
	}
}