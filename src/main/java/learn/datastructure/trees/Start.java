package practice.datastructure.trees;

public class Start {

	public static void main(String[] args) {
		ListNode head = null;
		ListNode headA = null;
		ListNode headB = null;
		ListNode ptr = null;
		ListNode mergeNode = null;
		for (int i = 0; i < 3; i++) {
			ListNode node = new ListNode(i + 1);
			if (i == 2) {
				mergeNode = node;
			}
			if (head == null) {
				head = node;
			}
			if (ptr != null)
				ptr.next = node;

			
			ptr = node;
		}
		headA = head;
		ListNode.printList(headA);

		head = null;
		/*
		 * for (int i = 0; i <= 2; i++) { ListNode node = new ListNode(i + 1);
		 * 
		 * if (i+1 == mergeNode.val) { node = mergeNode; } if (headB == null) { headB =
		 * node; } if (ptr != null) ptr.next = node;
		 * 
		 * ptr = node; }
		 */
		headB = new ListNode(1);
		headB.next = mergeNode;
		ListNode.printList(headB);
		ListNode intersectionNode = ListNode.getIntersectionNode(headA, headB);
		System.out.println(intersectionNode.val);
		// ListNode nHead = ListNode.reverseList(head);
		// ListNode nHead = ListNode.reverseListR(head); ListNode nHead =
	//	ListNode nHead = ListNode.swapPairsR(head);
	//	ListNode n = nHead;
		//while (n != null) {
			//System.out.print(n.val + " -> ");
			//n = n.next;
		//}
	//	System.out.print("null\n");
		/*
		 * for (int i = 0; i < 4; i++) { ListNode node = new ListNode(i + 1);
		 * 
		 * if (headA == null) { headA = node; } if (ptr != null) ptr.next = node;
		 * 
		 * ptr = node; } ptr = null;
		 * 
		 * for (int i = 0; i < 7; i++) { ListNode node = new ListNode(i + 1);
		 * 
		 * if (headB == null) { headB = node; } if (ptr != null) ptr.next = node;
		 * 
		 * ptr = node; }
		 */

	}

}
