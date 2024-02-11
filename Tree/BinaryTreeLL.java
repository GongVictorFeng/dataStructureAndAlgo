import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL{
	BinaryNode root;

	// PreOrder Traversal
	void preOrder(BinaryNode node){
		if(node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	// InOrder Traversal
	void inOrder(BinaryNode node){
		if(node == null){
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}

	void postOrder(BinaryNode node){
		if(node == null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}

	void levelOrder(){
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryNode currentNode = queue.remove();
			System.out.print(currentNode.value + " ");

			if(currentNode.left != null){
				queue.add(currentNode.left);
			}

			if(currentNode.right != null){
				queue.add(currentNode.right);
			}
		}
	}

	public void search(String value){
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryNode currentNode = queue.remove();
			if(currentNode.value.equals(value)){
				System.out.println("The value-" + value + " is found in Tree");
				return;
			}
			if(currentNode.left != null){
				queue.add(currentNode.left);
			}
			if(currentNode.right != null){
				queue.add(currentNode.right);
			}
		}
		System.out.println("The value-" + value + " is not found in Tree");
	}

	public void insert(String value){
		BinaryNode newNode = new BinaryNode();
		newNode.value = value;
		if(root == null){
			root = newNode;
			System.out.println("Insert new node in root");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryNode currentNode = queue.remove();
			if(currentNode.left == null){
				currentNode.left = newNode;
				System.out.println("Successfully insert");
				return;
			}
			if(currentNode.right == null){
				currentNode.right = newNode;
				System.out.println("Successfully insert");
				return;
			}
			queue.add(currentNode.left);
			queue.add(currentNode.right);
		}
	}

	public BinaryNode getDeepestNode(){
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode currentNode = null;
		while(!queue.isEmpty()){
			currentNode = queue.remove();
			if(currentNode.left != null){
				queue.add(currentNode.left);
			}
			if(currentNode.right != null){
				queue.add(currentNode.right);
			}
		}
		return currentNode;
	}

	public void deleteDeepestNode(){
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode prevNode, currentNode = null;
		if(root.left == null){
			root = null;
			System.out.println("The root is deleted since this binary tree only has root");
			return;
		}
		while(!queue.isEmpty()){
			prevNode = currentNode;
			currentNode = queue.remove();
			if(currentNode.left == null){
				prevNode.right = null;
				return;
			}
			if(currentNode.right == null){
				currentNode.left = null;
				return;
			}
			queue.add(currentNode.left);
			queue.add(currentNode.right);
		}
	}

	public void deleteNode(String value){
		Queue<BinaryNode> queue = new LinkedList<>();
		BinaryNode currentNode = null;
		queue.add(root);
		while(!queue.isEmpty()){
			currentNode = queue.remove();
			if(currentNode.value.equals(value)){
				currentNode.value = getDeepestNode().value;
				deleteDeepestNode();
				System.out.println("The node is Successfully deleted");
				return;
			}
			if(currentNode.left != null) queue.add(currentNode.left);
			if(currentNode.right != null) queue.add(currentNode.right);
		}
		System.out.println("No such node exist in this binary tree");
	}

	public static void main(String[] args) {
		BinaryTreeLL binaryTree = new BinaryTreeLL();
		int numNode = 9;
		for(int i = 0; i < numNode; i++){
			binaryTree.insert("N" + (i + 1));
		}
		binaryTree.preOrder(binaryTree.root);
		System.out.println();
		binaryTree.inOrder(binaryTree.root);
		System.out.println();
		binaryTree.postOrder(binaryTree.root);
		System.out.println();
		binaryTree.levelOrder();
		System.out.println();
		binaryTree.search("N5");
		System.out.println(binaryTree.getDeepestNode().value);
		binaryTree.deleteDeepestNode();
		binaryTree.levelOrder();
		System.out.println();
		binaryTree.deleteDeepestNode();
		binaryTree.levelOrder();
		System.out.println();
		System.out.println(binaryTree.getDeepestNode().value);
		binaryTree.deleteNode("N3");
		System.out.println();
		binaryTree.levelOrder();
	}
}