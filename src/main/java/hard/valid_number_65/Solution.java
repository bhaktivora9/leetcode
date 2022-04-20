package hard.valid_number_65;

class Solution {
	public static boolean isNumber(String s) {
		boolean num = false, exp = false, sign = false, dec = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			System.out.println(c);
			if (c >= '0' && c <= '9') {
				num = true;
			} else if (c == 'e' || c == 'E') {
				if (exp || !num) {
					return false;
				} else {
					exp = true;
					sign = false;
					num = false;
					dec = false;
				}
			} else if (c == '+' || c == '-') {
				if (sign || num || dec) {
					return false;
				} else {
					sign = true;
				}
			} else if (c == '.') {
				if (dec || exp) {
					return false;
				} else {
					dec = true;
				}
			} else {
				return false;
			}

		}
		return num;
	}

	/*
	 * public static boolean isNumber(String s) { boolean flagForE = false; boolean
	 * flagForDot = false; boolean flagForMinus = false; boolean flagForPlus =
	 * false; for (int i = 0; i <= s.length() - 1; i++) {
	 * 
	 * char c = s.charAt(i); System.out.println("Processing " + c + " at " + i);
	 * 
	 * if (c == 'e' || c == 'E') { if (flagForE || s.length() == 1) { return false;
	 * } else { try { char charBefore = s.charAt(i - 1); char charAfter = s.charAt(i
	 * + 1); if ((!(charBefore >= 48 && charBefore <= 57) || !(charAfter >= 48 &&
	 * charAfter <= 57))) { return false; } } catch (Exception e) {
	 * 
	 * }
	 * 
	 * } } else if (c == '+') { if (flagForPlus || s.length() == 1) { return false;
	 * } else { // System.out.println("Dot found at " + i); flagForPlus = true; } }
	 * else if (c == '.') { if (flagForDot || s.length() == 1) { return false; }
	 * else { // System.out.println("Dot found at " + i); flagForDot = true; } }
	 * else if (c == '-') { if (flagForMinus || s.length() == 1) { return false; }
	 * else { // System.out.println("Minus found at " + i); flagForMinus = true; } }
	 * else if (c < 48 || c > 57) { return false; } } return true; }
	 */
	public static void main(String[] args) {
		System.out.println(isNumber("53.5e93"));
	}

}