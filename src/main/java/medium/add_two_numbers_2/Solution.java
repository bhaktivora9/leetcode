package medium.add_two_numbers_2;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l1 = ListNode.generate(new int[] { 2, 4, 9 });
		ListNode l2 = ListNode.generate(new int[] { 5, 6, 4, 9 });
		s.addTwoNumbers(l1, l2);
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		static ListNode generate(int[] arr) {
			ListNode head = null;
			ListNode ptr = null;
			// ptr = head;
			for (int i = 0; i < arr.length; i++) {
				ListNode node = new ListNode(arr[i], null);
				if (i == 0) {
					head = node;

				} else {
					ptr.next = node;
				}
				ptr = node;
			}
			return head;

		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode node1 = l1;
		ListNode node2 = l2;
		int carry = 0;
		ListNode ptr = null;
		while (node1 != null || node2 != null) {
			int val1, val2;
			if (node1 == null) {
				val1 = 0;
			} else {
				val1 = node1.val;
			}
			if (node2 == null) {
				val2 = 0;

			} else {
				val2 = node2.val;
			}
			if (node1 != null) {
				node1 = node1.next;
			}
			if (node2 != null) {
				node2 = node2.next;
			}

			ListNode node = new ListNode();

			int sum = (val1 + val2) + carry;
			int d = sum % 10;
			carry = sum / 10;
			System.out.println("sum " + sum + " d " + d + " carry " + carry);
			node.val = d;
			if (ptr == null) {
				head = node;
			} else {
				ptr.next = node;
			}
			ptr = node;
		}
		while (carry > 0)

		{
			ListNode node = new ListNode();
			int d = carry % 10;
			carry = carry / 10;
			node.val = d;
			if (ptr == null) {
				head = node;
			} else {
				ptr.next = node;
			}
			ptr = node;
		}

		return head;
	}

}
