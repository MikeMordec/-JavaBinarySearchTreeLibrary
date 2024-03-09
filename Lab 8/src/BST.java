//Create a Helper Class
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BST {
	Node root; // root of BST
	int count = 0;

	BST() {
		root = null;
		count = 0;
	}

	Node insertRec(Node root, int data) {
		//insert into tree
		if (root == null) {
			this.count++;
			root = new Node(data);
			return root;
		}
		if (data < root.data) // insert left child
			root.left = insertRec(root.left, data);
		else if (data > root.data) // insert right child
			root.right = insertRec(root.right, data);
		return root;
	}

	//helper functions
	//call insertRec from main
	void insert(int data) {
		root = insertRec(root, data);
		System.out.println("New item inserted into tree => " + data);
	}
	
	Node searchRec(Node root, int data) {
		//insert into tree
		if (root == null) {
			return null;
		}
		if (root.data == data)
		{
			return root;
		}
		if (data < root.data) // insert left child
			root.left = searchRec(root.left, data);
		else if (data > root.data) // insert right child
			root.right =searchRec(root.right, data);
		return root;
	}

	//helper functions
	//call insertRec from main
	Node search(int data) {
		root = searchRec(root, data);
		return root;
	}

	//perform a postorder traversal
	void postorderRec(Node root) {
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.println(root.data);
		}
	}
	
	void preorderRec(Node root) {
		if (root != null) {
			System.out.println(root.data);
			postorderRec(root.left);
			postorderRec(root.right);
		}
	}
	
	void inorderRec(Node root) {
		if (root != null) {
			postorderRec(root.left);
			System.out.println(root.data);
			postorderRec(root.right);
		}
	}
	
	
	
	int getCount()
	{
		return count;
	}



//Returns the max value in a binary tree
	int findMax(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		int res = node.data;
		int lres = findMax(node.left);
		int rres = findMax(node.right);
		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

	public static void main(String[] args) {
		BST tree = new BST(); // create tree object
		/* Tree operations ************************/
		//build the tree
		//insert into tree
		tree.insert(27);
		tree.insert(13);
		tree.insert(42);
		tree.insert(6);
		tree.insert(17);
		tree.insert(33);
		tree.insert(48);
		//print max element of tree
		System.out.println("\nMaximum element is " + tree.findMax(tree.root));
		//print postorder of tree
		System.out.println("\nPostorder -> ");
		tree.postorderRec(tree.root);
		System.out.println("\nPreorder -> ");
		tree.preorderRec(tree.root);
		System.out.println("\nInorder -> ");
		tree.inorderRec(tree.root);
		System.out.print("\nCount -> ");
		System.out.println(tree.getCount());
		System.out.print("\nSearch -> ");
		Node node = tree.search(13);
		if(node!=null)
		{
			System.out.println("found node with data="+node.data);
		}
		else
		{
			System.out.println("Not found.");
		}
		System.out.println("Done.");

	}
}