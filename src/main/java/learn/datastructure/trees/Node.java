package practice.datastructure.trees;

public class Node {
	Node left;
	Node right;
	int val;

	public Node(int i) {
		val = i;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
