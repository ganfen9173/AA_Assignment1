import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
	
	private class Node<T> {
		private T item;
		private int count;
		private Node<T> nextNode;
		
		public Node(T item, int count, Node<T> nextNode) {
			item = this.item;
			count = this.count;
			nextNode = this.nextNode;
		}
		
		public Node() {}
	}
	
	private Node<T> mHead;
	
	
	public LinkedListMultiset() {
		// Implement me!
		mHead = null;
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		Node newItem = new Node<T>(item, 1, null);
		
		Node<T> node = mHead;
		while (node.nextNode != null) {
			node = node.nextNode; //find the last node
		}
		
		if (mHead == null) {
			mHead = newItem;
		}
		else {
			node.nextNode = new Node<T>(item, this.search(item), null);
		}
		// Implement me!
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		
		
		// default return, please override when you implement this method
		return 0;
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
	} // end of print()
	
} // end of class LinkedListMultiset