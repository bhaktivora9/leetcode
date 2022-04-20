package medium.copy_list_with_random_pointer_138;

import java.util.HashMap;

//Definition for a Node.
class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}
}

class Solution {
	public Node createList(int[][] arr) {
		Node head = null;
		Node prev = null;
		HashMap<Integer, Node> map = new HashMap<>();
		Node node = null;
		for (int i = 0; i < arr.length; i++) {
			prev = node;
			int value = arr[i][0];
			int randomIndex = arr[i][1];
			if (map.containsKey(i)) {
				node = map.get(i);
				node.val = value;
			} else {
				node = new Node(value);
			}
			if (i == 0) {
				head = node;
			}

			if (prev != null) {
				prev.next = node;
			}
			if (map.containsKey(randomIndex)) {
				Node random = map.get(randomIndex);
				node.random = random;
			} else {
				if (randomIndex >= 0) {
					Node random = new Node();
					node.random = random;
					map.put(randomIndex, random);
				}
			}
			if (!map.containsKey(i))
				map.put(i, node);
		}

		return head;

	}

	public void printLinkedList(Node head) {
		Node n = head;
		while (n != null) {

			System.out.println("Val " + n.val + ",Random = " + n.random);
			n = n.next;

		}
	}

	public Node copyRandomList(Node head) {
		Node nHead = new Node(head.val);
		nHead.next = head.next;
		HashMap<Node, Node> map = new HashMap<>();
		
		int i = 1;
		Node itr = head.next;
		Node prev = nHead;
		while (itr != null) {
			Node n = new Node(itr.val);
			prev.next = n;
			n.next = null;
			n = prev;
			itr = itr.next;
			i++;
		}

		return nHead;
	}
}