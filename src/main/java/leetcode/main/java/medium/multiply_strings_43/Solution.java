package medium.multiply_strings_43;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public String multiply(String num1, String num2) {
		int sum = 0;
		List<String> list = new ArrayList<>();
		int[] result = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			int index = num1.length() - 1 - i;
			int carry = 0;
			char n1 = num1.charAt(i);
			StringBuilder stringBuilder = new StringBuilder();
			for (int j = num2.length() - 1; j >= 0; j--) {
				char n2 = num2.charAt(j);
				int digit = (n1 - 48) * (n2 - 48) + carry;
				carry = digit / 10;
				int rem = digit % 10;
				result[i + j + index] = result[i + j + index] + rem;
				stringBuilder.append(rem);
				System.out.println("Multiply " + n1 + "*" + n2 + " = " + digit);
			}

			while (carry > 0) {
				stringBuilder.append(carry % 10);
				carry = carry / 10;
			}
			stringBuilder.reverse();
			while (index > 0) {
				stringBuilder.append(0);
				index--;
			}
			String string = stringBuilder.toString();
			list.add(string);
			System.out.println(string);
		}
		for (int i = 0; i < list.size(); i++) {
			String string = list.get(i);
		}
		System.out.println(result);
		return Integer.toString(sum);
	}

	public static void main(String[] args) {
		new Solution().multiply("35", "27");
		/*
		 * String str1 = "1235421415454545454545454544"; String str2 =
		 * "1714546546546545454544548544544545"; new Solution().multiply(str1,str2);
		 */
	}

}
