import java.io.PrintStream;

public class BstMultiset<T> extends Multiset<T>
{
	public class Node <T> {
		private T item;
		private int count;
		private Node<T> leftNode;
		private Node<T> rightNode;
		
		public Node(T item, int count, Node<T> leftNode, Node<T> rightNode){
			this.item = item;
			this.count = count;
			this.leftNode = rightNode;
			this.rightNode = rightNode;
		}
		
		public Node() {}
	}
	
	private Node<T> root;
	
	
	public BstMultiset() {
		// Implement me!
		root = null;
	} // end of BstMultiset()

	public void add(T item) {
		Node<T> currentNode = root;
		Node<T> parentNode = null;
		boolean flag = false;
		
		
		if (root == null) {
			root = new Node<T> (item, 1, null, null);
			flag = true;
		} else {
			while (currentNode != null) {
				if (item.toString().compareTo(currentNode.item.toString()) < 0) {
					parentNode = currentNode;
					currentNode = currentNode.leftNode;
				} else  if (item.toString().compareTo(currentNode.item.toString()) > 0){
					parentNode = currentNode;
					currentNode = currentNode.rightNode;
				} else {
					currentNode.count ++;
					flag = true;
					break;
				}
			}
		}
		
		if (!flag) {
			if (item.toString().compareTo(parentNode.item.toString()) < 0) {
				parentNode.leftNode = new Node<T> (item, 1, null, null);
			} else {
				parentNode.rightNode = new Node<T> (item, 1, null, null);
			} 
		}
		// Implement me!
	} // end of add()


	public int search(T item) {
		// Implement me!
		Node<T> currentNode = root;
		while (currentNode != null) {
			if (item.toString().compareTo(currentNode.item.toString()) < 0) {
				currentNode = currentNode.leftNode;
			} else if (item.toString().compareTo(currentNode.item.toString()) > 0){
				currentNode = currentNode.rightNode;
			} else {
				return currentNode.count;
			}
		}
		// default return, please override when you implement this method
		return 0;
	} // end of add()


	public void removeOne(T item) {
		Node<T> currentNode = root;
		Node<T> targetNode = null;
		while (currentNode != null) {
			if (item.toString().compareTo(currentNode.item.toString()) < 0) {
				currentNode = currentNode.leftNode;
			} else if (item.toString().compareTo(currentNode.item.toString()) > 0){
				currentNode = currentNode.rightNode;
			} else {
				targetNode = currentNode;
			}
		}
		if (targetNode != null && targetNode.count > 1) {
			targetNode.count --;
		} 
		if (targetNode != null && targetNode.count <= 1) {
			this.removeAll(item);
		} 
		
		// Implement me!
	} // end of removeOne()
	
	
	public Node<T> deleteNode(Node<T> node, T item) {
		if (node == null) {
			return node;
		}
		if (item.toString().compareTo(node.item.toString()) < 0 ) {
			node.leftNode = deleteNode(node.leftNode, item);
		} else if (item.toString().compareTo(node.item.toString()) > 0){
			node.rightNode = deleteNode(node.rightNode, item);
		} else {
			if (node.leftNode == null) {
				return root.rightNode;
			} else if (node.rightNode == null){
				return node.leftNode;
			}
			
			node.item = minValue (node.rightNode).item;
			node.count = minValue (node.rightNode).count;
			node.rightNode = deleteNode(node.rightNode, item);
		}
			
		return node;
	}
	
	public Node<T> minValue(Node<T> node) {
		Node<T> min = new Node<T>();
		while (node.leftNode != null) {
			min = node.leftNode;
		}
		return min;
	}
	public void removeAll(T item) {
		root = deleteNode(root, item);
		
//		Node<T> currentNode = root;
//		Node<T> parentNode = null;
//		Node<T> target = null;
//		while (currentNode != null) {
//			if (item.toString().compareTo(currentNode.item.toString()) < 0) {
//				parentNode = currentNode;
//				currentNode = currentNode.leftNode;
//			} else if (item.toString().compareTo(currentNode.item.toString()) > 0){
//				parentNode = currentNode;
//				currentNode = currentNode.rightNode;
//			} else {
//				target = currentNode;
//				break;
//			}
//		}
//		
//		if (target != null) {
//			if (target.leftNode == null && target.rightNode == null) {
//				if (target.item.toString().compareTo(parentNode.item.toString()) < 0) {
//					parentNode.leftNode = null;
//				} else {
//					parentNode.rightNode = null;
//				}
//			}
//			
//			else if (target.leftNode == null && target.rightNode !=null) {
//				if (target.item.toString().equals(root.item.toString())) {
//					root = target.rightNode;	
//				} else {
//					if (target.item.toString().compareTo(parentNode.item.toString()) > 0) {
//						parentNode.rightNode = target.rightNode;
//					} else {
//						parentNode.leftNode = target.rightNode;
//					}
//				}
//			}
//			
//			else if (target.rightNode == null && target.leftNode !=null) {
//				if (target.item.toString().equals(root.item.toString())) {
//					root = target.leftNode;
//				} else {
//					if (target.item.toString().compareTo(parentNode.item.toString()) > 0) {
//						parentNode.rightNode = target.leftNode;
//					} else {
//						parentNode.leftNode = target.leftNode;
//					}
//				}
//			}
//			
//			else {
//				Node <T> smallestNode = target.rightNode;
//				Node <T> nextNode = null;
//				Node <T> recordNode = null;
//				while (smallestNode.leftNode != null) {
//					nextNode = smallestNode;
//					smallestNode = smallestNode.leftNode;
//					recordNode = smallestNode;
//				}
//				if (target.item.toString().compareTo(parentNode.item.toString()) > 0) {
//					parentNode.rightNode = smallestNode;
//				} else {
//					parentNode.leftNode = smallestNode;	
//				}
//				
//				smallestNode.leftNode = target.leftNode;
//				smallestNode.rightNode = target.rightNode;
//				
//				if (smallestNode.rightNode == smallestNode) {
//					smallestNode.rightNode = recordNode.rightNode;
//				} else {
//					nextNode.leftNode = null;
//				}
				
//			}
//		}
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		this.printNode(root);
		// Implement me!
	} // end of print()
	
	public void printNode(Node node) {
		if (node == null) {
			return;
		} else {
			printNode(node.leftNode);
			System.out.println (node.item + printDelim + node.count);
			printNode(node.rightNode);
		}
	}

} // end of class BstMultiset
