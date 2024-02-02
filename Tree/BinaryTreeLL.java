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
			else{
				if(currentNode.left != null){
					queue.add(currentNode.left);
				}
				if(currentNode.right != null){
					queue.add(currentNode.right);
				}
			}
		}
		System.out.println("The value-" + value + " is not found in Tree");
	}

	public static void main(String[] args) {
		BinaryTreeLL binaryTree = new BinaryTreeLL();
		BinaryNode[] binaryNodes = new BinaryNode[9];
		for(int i = 0; i < binaryNodes.length;){
			binaryNodes[i] = new BinaryNode();
			binaryNodes[i].value = "N" + (++i);
		}
		binaryNodes[0].left = binaryNodes[1];
		binaryNodes[0].right = binaryNodes[2];
		binaryNodes[1].left = binaryNodes[3];
		binaryNodes[1].right = binaryNodes[4];
		binaryNodes[2].left = binaryNodes[5];
		binaryNodes[2].right = binaryNodes[6];
		binaryNodes[3].left = binaryNodes[7];
		binaryNodes[3].right = binaryNodes[8];
		binaryTree.root = binaryNodes[0];
		binaryTree.preOrder(binaryTree.root);
		System.out.println();
		binaryTree.inOrder(binaryTree.root);
		System.out.println();
		binaryTree.postOrder(binaryTree.root);
		System.out.println();
		binaryTree.levelOrder();
		System.out.println();
		binaryTree.search("N5");
	}
}