package medium.sequential_digits_1291;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static List<Integer> sequentialDigits1(int low, int high) {
		List<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < 10; i++)
			q.add(i); // add 1 - 9 all digits in queue
		while (q.size() > 0) {
			int curr = q.poll(); // poll curr from queue
			if (curr >= low && curr <= high)
				result.add(curr); // check if current >= low and <= high add
			int lastDigit = curr % 10;
			int next = curr * 10 + lastDigit + 1; // generate next num
			if (lastDigit < 9 && next <= high)
				q.add(next); // check if next num <= high add in queue
		}
		return result;
	}

	static List<Integer> sd(int low, int high) {

		List<Integer> result = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < 10; i++) {
			q.add(i);
		}
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr >= low && curr <= high) {
				result.add(curr);
			}
			int lastDigit = curr % 10;
			int next = curr * 10 + lastDigit + 1;
			System.out.println(next);

			if (lastDigit < 9 && next <= high) {
				q.add(next);
			}
		}
		return result;
	}

	public static List<Integer> sequentialDigits(int low, int high) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String lowString = Integer.toString(low);
		String h = Integer.toString(high);
		int len = h.length();
		char start = lowString.charAt(0);
		int num = low;
		int index = start - 48;
		int inc = index;
		for (int i = lowString.length(); i <= h.length(); i++) {
			len = i;

			num = 0;
			while (num <= high) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < len; j++) {

					sb.append(Integer.toString(inc));
					inc = inc + 1;
				}
				index = index + 1;
				inc = index;
				num = Integer.valueOf(sb.toString());
				if (num <= high) {
					System.out.println(num);
					list.add(num);
				}
			}
			index = 1;
			inc = index;

		}
		return list;
	}

	public static void main(String[] args) {
		// System.out.println(sequentialDigits1(10, 1000000000));
		// System.out.println(sd(10, 1000000000));
//		String s = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
		String s = "0P";
		String str = s.replaceAll("[\\W\\d]", "");
		str = str.toLowerCase();
		boolean isPalindrome ;
		if (str.isEmpty()) {
			isPalindrome = true;
		} else {
			isPalindrome = checkPalindrome(str);
		}
		System.out.println(isPalindrome);
	}

	public static boolean checkPalindrome(String s) {
		System.out.println("Checking " + s);
		char c1 = s.charAt(0);
		char c2 = s.charAt(s.length() - 1);
		if (c1 != c2) {
			return false;
		}
		if (s.length() <= 2) {
			return true;
		} else {
			return checkPalindrome(s.substring(1, s.length() - 1));
		}

	}
}