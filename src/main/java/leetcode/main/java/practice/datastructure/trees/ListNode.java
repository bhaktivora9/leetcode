package practice.datastructure.trees;

import java.util.Stack;

public class ListNode {

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

	public static void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.print("null\n\n");

	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA;
		ListNode b = headB;
		System.out.println("a = " + a.val + " ,b = " + b.val);

		while (a != b) {
			a = (a == null) ? headB : a.next;
			b = (b == null) ? headA : b.next;
			//System.out.println("a = " + a.val + " ,b = " + b.val);
		}
		return a;
	}

	public static ListNode swapPairsR(ListNode head) {

		if (head == null || head.next == null) {
	
			return head;
		}
		System.out.println("Head @ "+head.val +", swapping "+head.val + " , "+head.next.val);
		ListNode temp = head;
		head = head.next;
		temp.next = head.next;
		head.next = temp;

		ListNode swapPairsR = swapPairsR(head.next.next);
		if(swapPairsR == null) System.out.println("Returning  "+swapPairsR);
		else {
			System.out.println("Returning  "+swapPairsR.val);
		}

		head.next.next = swapPairsR;
		return head;
	}

	public static ListNode swapPairs(ListNode head) {

		ListNode node = head;
		boolean flag = true;
		while (node != null && node.next != null) {
			ListNode first = node;
			ListNode temp = node.next.next;
			node = node.next;
			node.next = first;
			node.next.next = temp;
			if (flag) {
				head = node;
				flag = false;
			}
			if (node.next != null) {
				node = node.next.next;
			} else {

				node = null;
			}
			// printList(head);

		}
		return head;
	}

	private static ListNode swap(ListNode node1, ListNode node2) {
		return node2;

	}

	public static ListNode reverseListR(ListNode head) {
		System.out.println("Calling func " + head.val);
		// last node or only one node
		if (head.next == null) {
			System.out.println("Returning func " + head.val);

			return head;
		}

		ListNode newHeadNode = reverseListR(head.next);

		// change references for middle chain

		System.out.println("Returning func with node as " + head.val + " and newHead as " + newHeadNode.val);
		head.next.next = head;
		head.next = null;

		// send back new head node in every recursion

		return newHeadNode;
	}

	public static ListNode helper(ListNode node, ListNode prev) {
		System.out.println("Calling func " + node.val);

		if (node.next == null) {
			System.out.println("Returning func " + node.val);

			return node;
		}
		// prev = node;
		ListNode helper = helper(node.next, node);
		node.next.next = node;
		return helper;

	}

	public static ListNode reverseList(ListNode head) {
		/*
		 * ListNode node = new ListNode(head.val); if (head.next == null) return head;
		 * 
		 * return reverseList(head.next);
		 */
		Stack<ListNode> st = new Stack<>();
		ListNode node = head;
		while (node != null) {
			st.push(node);
			node = node.next;
		}

		ListNode nHead = st.pop();
		ListNode prev = nHead;
		while (!st.isEmpty()) {
			ListNode n = st.pop();
			// System.out.println(prev.val+" "+n.val);
			prev.next = n;
			prev = n;
		}
		prev.next = null;
		return nHead;
	}
}
