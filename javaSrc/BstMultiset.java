import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T>
{
	public class Node {
		private T item;
		private int count;
		private Node leftNode;
		private Node rightNode;
		private Node parentNode;
		
		public Node(T item, int count, Node leftNode, Node rightNode, Node parentNode){
			this.item = item;
			this.count = count;
			this.leftNode = rightNode;
			this.rightNode = rightNode;
			this.parentNode = parentNode;
		}
		public Node() {}
		
		public Node searchNode(T item) {
			Node current =root;
			Node parent = null;
			while (current != null) {
				if(item instanceof Integer){
					Integer num1 = (Integer) item;
					Integer num2 = (Integer) current.item;
					if(num1.compareTo(num2)>0) {
						parent=root;
						current=current.rightNode;
						current.parentNode = parent;
					}else if(num1.compareTo(num2)<0) {
						parent=root;
						current=current.leftNode;
						current.parentNode = parent;
					}else
						break;
				}
				if(item instanceof String) {
					String s = (String) item;
					if(item.toString().compareTo(current.item.toString())>0) {
						parent=root;
						current=current.rightNode;
						current.parentNode = parent;
					}else if(item.toString().compareTo(current.item.toString())<0) {
						parent=root;
						current=current.leftNode;
						current.parentNode = parent;
					}else
						break;
				}
			}
			return current;
			
		}
		
		public Node findMin(Node node) {
			Node current = node;
			while (current.leftNode != null) {
				current = current.leftNode;
			}
			return current;
		}
		
	}
	
	private Node root;
	
	public BstMultiset() {
		root = null;
		// Implement me!
	} // end of BstMultiset()

	public void add(T item) {
		// Implement me!
		Node current = root;
		if (current == null) {
			Node newNode = new Node(item,1,null,null,null);
			root = newNode;
		}
		else
			current = root.searchNode(item);
			
	} // end of add()


	public int search(T item) {
		// Implement me!
		Node currentNode = root.searchNode(item);
		if (currentNode == null) {
			return 0;
		}else
			return currentNode.count;
	} // end of add()


	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
		Node current = root.searchNode(item);
		if (current.leftNode == null && current.rightNode==null) {
			if (current == current.parentNode.leftNode) {
				current.parentNode.leftNode = null;
			}else {
				current.parentNode.rightNode = null;}
		}
		else if(current.leftNode == null && current.rightNode != null) {
			current.parentNode.rightNode=current.rightNode;
		}
		else if(current.rightNode == null && current.leftNode != null) {
			current.parentNode.leftNode=current.leftNode;
		}
		else if(current.rightNode != null && current.leftNode !=null){
			if(current == root) {
				
			}
			else {
				Node minNode = root.findMin(current.rightNode);
				current.item = minNode.item;
				current.count = minNode.count;
				minNode.parentNode.leftNode =null;
			}
		}
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
	} // end of print()

} // end of class BstMultiset