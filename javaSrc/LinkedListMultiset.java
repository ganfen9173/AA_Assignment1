import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
	
	private class Node<T> {
		private T item;
		private int count;
		private Node<T> nextNode;
		
		public Node(T item, int count, Node<T> nextNode) {
			this.item = item;
			this.count = count;
			this.nextNode = nextNode;
		}
		
		public Node() {}			
		
	}
	
	private Node<T> mHead;
	
	
	public LinkedListMultiset() {
		// Implement me!
		mHead = null;
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		Node<T> newItem = new Node<T>(item, 1, null);
		
		Node<T> node = new Node<T>();
		node = mHead;
		
		if (mHead != null) {
			while (node.nextNode != null) {
				node = node.nextNode; //find the last node
			}
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
		int count = 0;
		Node<T> target = mHead;
		while (target != null) {
			if(item == target.item) {
				count++;
			}
			target = target.nextNode;
		}
		// default return, please override when you implement this method
		return count;
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
		Node<T> current = mHead;
		Node<T> previous = null;
		
		while (current.nextNode !=null) {
			if(current == item) {
				if(current == mHead) {
					mHead = current.nextNode;
				}else
					previous.nextNode = current.nextNode;
			}
			previous = current;
			current = current.nextNode;
		}
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
		Node<T> current = mHead;
		while (current !=null) {
			removeOne(item);
		}
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
	} // end of print()
	
} // end of class LinkedListMultiset