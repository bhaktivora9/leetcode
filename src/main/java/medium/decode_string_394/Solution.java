package medium.decode_string_394;
/*
 * Click `Run` to execute the snippet below!
 */

import java.util.Stack;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 
 * Decode String - Given encoded string return decoded string where encoding rule is k[encoded_string] where encoded_string in bracket is being repeated k times 

"3[a2[c]]" would become "accaccacc"
 *
 * If you need more classes, simply define them inline.
 */

//digit = [3,2]
//char = [a,c]
//temp = acc
//ans = cca = > accacc
class Solution {
	static int index = 0;

	public static void main(String[] args) {

		// System.out.println(decodeString("3[a2[c]]"));
		// System.out.println(decodeString("3[a2[bc]]"));
		// System.out.println(decodeString1("3[a2[c]]"));
		// System.out.println(decodeString("2[3[a]2[bc]]"));
//		System.out.println(decodeString("2[3[a]2[bc]]d"));
//		System.out.println(decodeStringR("2[3[a]2[bc]]"));
		//System.out.println(decodeStringR("2[3[a]2[bc]]"));
		// System.out.println(decodeString("abc"));
	//	System.out.println(decodeString1("abc"));
		// System.out.println(decodeString("abc2[def]"));
		// System.out.println(decodeString("10[a2[bc]]"));
		//System.out.println(decodeString1("10[a2[bc]]"));
		 System.out.println(decodeStringR("10[1[leet]2[code]]"));

	}

	public static boolean isDigit(char c) {
		return (c - '0') >= 0 && (c - '0') < 9;
	}

	public static String decodeString1(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder currentString = new StringBuilder();
		int k = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0';
			} else if (ch == '[') {
				// push the number k to countStack
				countStack.push(k);
				// push the currentString to stringStack
				stringStack.push(currentString);
				// reset currentString and k
				currentString = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder decodedString = stringStack.pop();
				// decode currentK[currentString] by appending currentString k times
				for (int currentK = countStack.pop(); currentK > 0; currentK--) {
					decodedString.append(currentString);
				}
				currentString = decodedString;
			} else {
				currentString.append(ch);
			}
		}
		return currentString.toString();
	}

	public static String decodeString(String s) {
		Stack<Integer> digits = new Stack<Integer>();
		Stack<String> strStack = new Stack<String>();
		String ans = "";
		String curr = "";
		Character prevChar = null;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (currChar == ']') {
				for (String x = strStack.pop(); !x.equals("["); x = strStack.pop()) {
					curr = x + curr;
				}
				String temp = "";
				for (int count = digits.pop(); count > 0; count--) {
					temp = temp + curr;
				}
				strStack.push(temp);
				curr = "";
			} else if (isDigit(currChar)) {
				if (prevChar != null && isDigit(prevChar)) {
					String x = Integer.toString(digits.pop()) + Character.toString(currChar);

					digits.push(Integer.valueOf(x));

				} else {
					digits.push(currChar - '0');
				}
			} else {
				strStack.push(Character.toString(currChar));
			}
			prevChar = currChar;
		}

		while (!strStack.isEmpty()) {
			ans = strStack.pop() + ans;
		}
		return ans;
	}

	public static String getResult(Stack<String> ans) {
		StringBuilder sb = new StringBuilder();
		while (!ans.isEmpty()) {
			String s = ans.pop();
			sb.append(s);
		}

		return sb.toString();
	}

	static String decodeStringR(String s) {
		StringBuilder result = new StringBuilder();
		while (index < s.length() && s.charAt(index) != ']') {
			if (!Character.isDigit(s.charAt(index)))
				result.append(s.charAt(index++));
			else {
				int k = 0;
				// build k while next character is a digit
				while (index < s.length() && Character.isDigit(s.charAt(index)))
					k = k * 10 + s.charAt(index++) - '0';
				// ignore the opening bracket '['
				index++;
				String decodedString = decodeStringR(s);
				// ignore the closing bracket ']'
				index++;
				// build k[decodedString] and append to the result
				while (k-- > 0)
					result.append(decodedString);
			}
		}
		return new String(result);
	}

}
