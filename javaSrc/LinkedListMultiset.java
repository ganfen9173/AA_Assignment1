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
		
		if (mHead == null) {
			mHead = newItem;
		}
		else {
			while (node.nextNode != null) {
				node = node.nextNode; //find the last node
			}
			node.nextNode = new Node<T>(item, search(item)+1, null);
		}
		// Implement me!
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		Node<T> current = mHead;
		Node<T> target = new Node<T>();
		while (current.nextNode != null) {
			if(item == current.item) {
				target = current;
			}
			current = current.nextNode;
		}
		// default return, please override when you implement this method
		return target.count;
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
				break;
			}
			previous = current;
			current = current.nextNode;
		}
//github.com/ganfen9173/AA_Assignment1.git
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
		Node<T> current = mHead;
		while (current !=null) {
			removeOne(item);
		}
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		Set set = new HashSet();
		
		Node<T> node = mHead;
		node.count = this.search(node.item);
		out.println(node.item + printDelim + node.count);
		set.add(node.item);
		node = node.nextNode;
		while (node != null) {
			for (int i = 0; i < set.size(); i ++) {
				if (!set.contains(node.item)) {
					node.count = this.search(node.item);
					out.println(node.item + printDelim + node.count);
					set.add(node.item);
				}
				node = node.nextNode;
			}
		}
		// Implement me!
	} // end of print()
	
} // end of class LinkedListMultiset
