package medium.copy_list_with_random_pointer_138;

public class Start {

	public static void main(String[] args) {
		Solution solution = new Solution();
		Node head = solution.createList(new int[][] { { 7, -1 }, { 13, 0 }, { 11, 4 }, { 10, 2 }, { 1, 0 } });
		solution.printLinkedList(head);
		solution.copyRandomList(head);

	}

}
