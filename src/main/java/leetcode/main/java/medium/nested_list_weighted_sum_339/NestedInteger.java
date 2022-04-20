package medium.nested_list_weighted_sum_339;

import java.util.List;

public class NestedInteger implements NestedIntegerInterface {

	private int value;
	private List<NestedInteger> list;
	private boolean isInt;

	public NestedInteger(int value, List<NestedInteger> list) {
		if (((list == null) || list.isEmpty()) && !Integer.valueOf(value).equals(null)) {
			isInt = true;
		}
		this.value = value;
		this.list = list;

	}

	public NestedInteger(Integer valueOf, List<NestedInteger> asList) {
		if (!list.isEmpty() && !Integer.valueOf(value).equals(null)) {
			isInt = true;
		}
		this.value = valueOf;
		this.list = asList;

	}

	public NestedInteger(String string, List<NestedInteger> list1) {
		try {
			if (string == null || string.isEmpty()) {
				isInt = false;
			} else {
				Integer valueOf = Integer.valueOf(string);
				if (!list.isEmpty() && !Integer.valueOf(value).equals(null)) {
					isInt = true;
				}
				this.value = valueOf;
			}
		} catch (Exception e) {

		} finally {
			this.list = list1;

		}
	}

	@Override
	public boolean isInt() {
		return isInt;
	}

	@Override
	public int getInt() {
		return value;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}

}
