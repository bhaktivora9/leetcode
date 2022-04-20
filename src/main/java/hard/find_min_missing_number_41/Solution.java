package hard.find_min_missing_number_41;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

public class Solution {

	/*
	 * public int solution(int[] A) { HashSet<Integer> set = new HashSet<>(); int
	 * max = A.length; for (int i = 0; i < A.length; i++) { //max = nums[i] > max ?
	 * nums[i] : max; set.add(A[i]); } List<Integer> collect = IntStream.range(1,
	 * max+1).boxed().collect(Collectors.toList()); collect.removeAll(set); return
	 * collect.isEmpty() ? (max + 1 > 0 ? max + 1 : 1) : collect.get(0);
	 * 
	 * }
	 */

	public int reverse(int x) {
		String s = Integer.toString(x);
		if (s.charAt(0) == '-') {
			String reverse = reverse(Math.abs(x), "");
			reverse = reverse.replaceAll("^0*", "");
			try {
				x = -Integer.valueOf(reverse);
			} catch (Exception e) {
				x = 0;
			}
			return x;
		}

		String reverse = reverse(x, "");
		reverse = reverse.replaceAll("^0*", "");
		try {
			x = Integer.valueOf(reverse);
		} catch (Exception e) {
			x = 0;
		}
		return x;
	}

	private String reverse(int x, String s) {
		System.out.println("Calling " + x + ", s = " + s);
		int i = x % 10;
		if (i == x) {
			System.out.println("Returning " + x);
			return s + i;
		}
		s = s + i;
		return (reverse(x / 10, s));
	}

	public int findDuplicate(int[] nums) {
		int n = nums.length;
		int[] m = new int[n];
		for (int i = 0; i < n; i++) {
			int x = nums[i];
			System.out.println("i = " + i + " x = " + x);
			if (m[x] != 0) {
				return x;
			} else {
				m[x] = x;
			}

		}
		return 1;
	}

	public int[] solution(int N) {
		// int[] arr = new int[N];
		Random random = new Random();
		// IntStream limitedIntStream = random.ints(N);
		int[] arr = new int[N];// limitedIntStream.toArray();

		for (int i = 0; i < N; i++) {
			int nextInt = Math.abs(random.nextInt());
			arr[i] = nextInt;
		}

		// Arrays.sort(arr);
		System.out.println("Array generated -> ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("");

		return arr;
	}

	public int find_min(int[] A) {
		int ans = 0;// A[0];
		for (int i = 1; i < A.length; i++) {
			if (ans > A[i]) {
				ans = A[i];
			}
		}
		System.out.println();
		return ans;
	}

	public boolean solution(int[] A) {
		/**
		 * If size of array is odd there will be one element always left
		 */
		int length = A.length;
		if (length % 2 != 0)
			return false;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])) {
				Integer integer = map.get(A[i]);
				map.put(A[i], integer + 1);
			} else {
				map.put(A[i], 1);

			}
		}
		for (Entry<Integer, Integer> element : map.entrySet()) {
			if (element.getValue() % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	public int solutionOddOccurenceInArray(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int a : A) {
			if (map.containsKey(a)) {
				int freq = map.get(a);
				map.put(a, freq + 1);
			} else {
				map.put(a, 1);
			}
		}

		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() % 2 != 0)
				return e.getKey();
		}
		return 0;
	}

	int distinctSubString(String S) {
		int count = (S.isEmpty()) ? 0 : 1;
		// S = S.toLowerCase();
		HashSet<Character> letters = new HashSet<Character>();
		HashSet<String> substr = new HashSet<String>();
		for (int i = 0; i < S.length(); i++) {
			if (letters.contains(S.charAt(i))) {
				String collect = letters.stream().map(String::valueOf).collect(Collectors.joining());
				substr.add(collect);
				letters.clear();
				count++;
			}
			letters.add(S.charAt(i));
		}
		substr.stream().forEach(System.out::println);
		return count;
	}

	public static void res(String r, int n) {
		String[] groups = new String[] { "ABC", "DEFG", "HJK" };
		String[] req = new String[] { "000", "DEFG", "HJK" };
		boolean[][] matrix = new boolean[10][n];
		String[] smatrix = new String[n];
		int count = 3 * n;
		String[] split = r.split(",");
		for (String string : split) {
			char charAt1 = string.charAt(0);
			Integer valueOf = Integer.valueOf(charAt1 - 1) - 48;
			int charAt2 = string.charAt(1) - 65;
			smatrix[valueOf] = "0000000000";
			switch (charAt2) {

			case 'A':
				matrix[0][valueOf] = true;
				count--;
				break;
			case 'B':
				matrix[1][valueOf] = true;
				count--;

				break;
			case 'C':
				matrix[2][valueOf] = true;
				count--;

				break;
			case 'D':
				matrix[3][valueOf] = true;

				break;
			case 'E':
				matrix[4][valueOf] = true;
				count--;

				break;
			case 'F':
				matrix[0][valueOf] = true;
				count--;

				break;
			case 'H':
				matrix[0][valueOf] = true;

				break;
			case 'J':
				matrix[0][valueOf] = true;
				count--;

				break;
			case 'K':
				matrix[0][valueOf] = true;
				count--;

				break;

			}

		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse(12000));
		System.out.println(solution.reverse(123));
		System.out.println(solution.reverse(-123));
		System.out.println(solution.reverse(2147483647));
		// System.out.println(solution.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		// System.out.println(solution.solution(new int[] { -1, -3 }));
		// System.out.println(solution.solution(new int[] { 1, 2, 3 }));
		// System.out.println(solution.solution(new int[] { 1, 2, 3, 10, 2147483647, 9
		// }));

		// System.out.println(solution.find_min(solution.solution(5)));
		// System.out.println(solution.solutionOddOccurenceInArray(new int[] { 2, 3, 3,
		// 2, 5, 9, 9 }));
		// System.out.println(solution.distinctSubString("abacdec"));
		// res("1A,1B,1H", 1);
		// airPlaneSeatReservation("1A,1B,1H", 1);
	}

	/*
	 * private static void airPlaneSeatReservation(String string, int n) { String[]
	 * groups = new String[] { "ABC", "DEFG", "HJK" }; String[] req = new String[] {
	 * "000", "DEFG", "HJK" }; //boolean[][] matrix = new boolean[10][n]; String[]
	 * smatrix = new String[n]; int count = 3 * n; for(int i = 0 ;i< n ;i++) {
	 * smatrix[i] = "0000000000"; string. } }
	 */
}
