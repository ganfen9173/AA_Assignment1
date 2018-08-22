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

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public Node<T> getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}			
		
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
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		Node<T> node = mHead;
		while (node != null) {
			node.setCount(this.search(node.item));
			//node.count = this.search(node.item);
			out.println(node.item + printDelim + node.count);
			node = node.nextNode;
		}
		// Implement me!
	} // end of print()
	
} // end of class LinkedListMultiset