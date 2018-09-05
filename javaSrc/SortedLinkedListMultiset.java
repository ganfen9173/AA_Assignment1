import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{
	class Node {
		protected T item;
		protected int count;
		protected Node nextNode;
		
		public Node(T item, int count, Node nextNode) {
			this.item = item;
			this.count = count;
			this.nextNode = nextNode;
		}

	}
	protected Node mHead;
	protected int length;
	
	public SortedLinkedListMultiset() 
	{
		mHead = null;
		length = 0;
	} // end of SortedLinkedListMultiset()
	
	public void add(T item) {
		// Implement me!
		if (mHead == null) {
			Node newNode = new Node(item, 1, null);
			mHead = newNode;
		}
		else {
			Node newNode = new Node(item, search(item)+1, mHead);
			mHead = newNode;
		}
		length = length + 1;
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		Node current = mHead;	
		while (current != null) {
			if(item.toString().equals(current.item.toString())) {
				break;
			}
			current = current.nextNode;
		}
		if(current == null) {
			return 0;
		}
		else {
			return current.count;
		}
		// default return, please override when you implement this method
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
	
} // end of class SortedLinkedListMultiset