package hard.find_min_missing_number_41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> ans = new ArrayList<Integer>();
		List<Integer> prev = new ArrayList<Integer>();
		ans = helper(0, rowIndex, prev);
		System.out.println(ans);
		return ans;
	}

	List<Integer> helper(int row, int total, List<Integer> prev) {
		List<Integer> arrayList = new ArrayList<>(row + 1);
		int[] arr = new int[row+1];
		if (row > total)
			return prev;
		if (row == 0) {
			arr[0] = 1;
		}
		else if (row == 1) {
			arr[0] = 1;
			arr[1] = 1;
		} else {
			arr[0] = 1;
			arr[row] = 1;
			for (int i = 0; i <= prev.size() - 2; i++) {
				int val = prev.get(i) + prev.get(i + 1);
				arr[i+1] = val;
			}
		}
		arrayList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		return helper(row + 1, total, arrayList);
	}

	public static void main(String[] args) {
		new PascalTriangle().getRow(25);
	}

}
