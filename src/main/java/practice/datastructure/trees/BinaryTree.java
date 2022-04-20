package practice.datastructure.trees;

public class BinaryTree {
	Node root;

	/*
	 * Compute the "maxDepth" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */

	int maxDepth(Node node) {
		if (node == null)
			return 0;
		else {
			// compute the depth of each subtree
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			// use the larger one
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}
	static int solution(int year) {
		if(year % 100 == 0) return year %100;
		return year/100+1;
		}

	/*
	 * public int maxDepth(Node root) { if (root == null) return 1; int left =
	 * maxDepth(root.left); // System.out.println(left); int right =
	 * maxDepth(root.right); System.out.println(right); int max = (left > right ?
	 * left : right); return max; }
	 */

	/* Driver program to test above functions */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(3);
		tree.root.left = new Node(9);
		tree.root.right = new Node(20);
		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(7);

		//System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
		solution(1905);
	}
}
