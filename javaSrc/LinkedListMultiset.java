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
	private int length;
	
	
	public LinkedListMultiset() {
		// Implement me!
		mHead = null;
		length = 0;
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
			node.nextNode = new Node<T>(item, this.search(item)+1, null);
		}
		length++;
		// Implement me!
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		int count = 0;
		Node<T> current = mHead;
		while (current != null) {
			if(item == current.item) {
				count++;
			}
			current = current.nextNode;
		}
		// default return, please override when you implement this method
		return count;
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
		Node<T> current = mHead;
		Node<T> previous = null;
		Node<T> removeNode = null;
		Node<T> pointToRemoveNode  = null;
		for(int i=length;i>0;i--){
			if(current.item == item) {
				removeNode = current;
				pointToRemoveNode = previous;
			}
			previous = current;
			current = current.nextNode;
		}
		if(removeNode != null) {
			if(removeNode == mHead) 
			{	
				mHead = removeNode.nextNode;
				System.out.println("");
			}else {
				pointToRemoveNode.nextNode= removeNode.nextNode;
			}
			length--;
		}
		if(removeNode == null) {
			System.out.println("Item not exist.");
		}
//github.com/ganfen9173/AA_Assignment1.git
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
		Node<T> current = mHead;
		while (current !=null) {
			removeOne(item);
			current = current.nextNode;
		}
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		String[] itemSet = new String[length];
		int numberOfPrint = 0;
		int numberOfItem = 0;
		Node<T> current = mHead;
		while(current != null) {
			if (itemSet[0] == null) {
				out.println(current.item + printDelim + search(current.item));
				itemSet[0] = current.item.toString();
				//System.out.println(itemSet.length);
				numberOfPrint += search(current.item);
				//System.out.println(numberOfPrint);
				numberOfItem++;
				//System.out.println(numberOfItem);
			}else {
				for(String item: itemSet){
					if(item == null) {
						out.println(current.item + printDelim + search(current.item));
						itemSet[numberOfItem] = current.item.toString();
						numberOfPrint += search(current.item);
						numberOfItem ++;
						break;
					}
					else if(item.toString() == current.item.toString()) {
						break;
					}
				}
				current = current.nextNode;
			}
			
			//System.out.println(current.item.toString()+current.count);
			//System.out.println(current.item.toString());
			if(length <= numberOfPrint) {
				System.out.print("exit while loop");
				break;
			}
		}
	  /*Set<T> set = new HashSet<T>();	
		Node<T> node = mHead;
		node.count = this.search(node.item);
		out.println(node.item + printDelim + node.count);
		set.add(node.item);
		while (node.nextNode != null) {
			for (int i = 0; i < set.size(); i ++) {
				if (!set.contains(node.item)) {
					node.count = this.search(node.item);
					out.println(node.item + printDelim + node.count);
					set.add(node.item);
				}
				node = node.nextNode;
			}
		}*/
		// Implement me!
	} // end of print()
	
} // end of class LinkedListMultiset
