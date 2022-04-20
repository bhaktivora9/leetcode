package practice.recurssion;

public class ReverseString {

	public static void main(String[] args) {

		String string = "hello";
		// System.out.println(reverse(string));
		// System.out.println(string.substring(0, string.length() - 1));;
		// System.out.println(add(5));
		// System.out.println(reverse(string));
		// printReverse(string.toCharArray());
		reverseString(string.toCharArray());

		// System.out.println(printFun(3, 1));
		;
	}

	public static void reverseString(char[] s) {
		char[] str = swap(s, 0, s.length - 1);
		System.out.println(str);
	}

	public static char[] swap(char[] s, int left, int right) {
		if (left >= right)
			return s;
		char tmp = s[left];
		s[left] = s[right];
		s[right] = tmp;
		char[] str = swap(s, left + 1, right - 1);
		return str;
	}

	static int printFun(int test, int sum) {
		if (test < 1) {
			System.out.println("Returning from " + test + " sum = " + sum);

			return sum;
		} else {
			System.out.println("Calling " + test + " sum = " + sum);
			// statement 2
			System.out.println("Now returning  " + sum);
			return printFun(test - 1, sum + test - 1);
		}
	}

	private static void printReverse(char[] str) {
		helper(0, str);
		System.out.println();

		int index = str.length - 1;
		System.out.println(helper(index, str, ""));
	}

	private static String helper(int index, char[] str, String string) {
		if (index < 0) {
			return string;
		}
		string = string + str[index];
		string = helper(index - 1, str, string);
		return string;
	}

	private static void helper(int index, char[] str) {
		if (str == null || index >= str.length) {
			return;
		}
		helper(index + 1, str);
		System.out.print(str[index]);
	}

	private static int add(int i) {
		if (i == 1) {
			return i;
		}
		System.out.println(i);
		return i + add(i - 1);
	}

	private static String reverse(String string) {
		return helper(string.length() - 1, "", string, string.charAt(string.length() - 1));
	}

	private static String helper(int i, String result, String string, char c) {
		if (i == 0)
			return result + c;
		i = i - 1;
		return helper(i, result, string, string.charAt(i));
	}

}
