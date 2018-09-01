import java.io.PrintStream;



public class SortedLinkedListMultiset<T> extends Multiset<T>
{
	public class Node <T> {
		private T item;
		private int count;
		private Node<T> nextNode;
		
		public Node(T item, int count, Node<T> nextNode){
			this.item = item;
			this.count = count;
			this.nextNode = nextNode;
		}
		
		public Node() {}
	}
	
	private Node<T> mHead;
	public int mLength;
	public SortedLinkedListMultiset() {
		mHead = null;
		mLength = 0;
	}
	
	public void add(T item) {
		Node<T> newItem = new Node<T>(item, this.search(item) + 1, null);		
		Node<T> current = new Node<T>();
		Node<T> finalNode = new Node<T>();
		Node<T> previous = null;
		
		current = mHead;
		boolean flag = false;
		if (mHead == null) {
			mHead = newItem;
		}
		else {
			while (current.nextNode != null) {
				current = current.nextNode; //find the last node
			}
			finalNode = current;
			current = mHead;
			while (current != null) {
				if (newItem.item.toString().compareTo(mHead.item.toString()) <= 0) {
					newItem.nextNode = mHead;
					mHead = newItem;
					flag = true;
					break;
				} else if (newItem.item.toString().compareTo(current.item.toString()) <= 0){
					newItem.nextNode = current;
					previous.nextNode = newItem;
					flag = true;
					break;
				} else {
					previous = current;
					current = current.nextNode;
				}
			}
			
			if (!flag) {
				finalNode.nextNode = new Node<T>(item, this.search(item) + 1, null);
			}
		}
		mLength ++;
		// Implement me!
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		int count = 0;
		Node<T> current = mHead;
		while (current != null) {
			if(item.equals(current.item)) {
				count++;
			}
			current = current.nextNode;
		}
		// default return, please override when you implement this method
		return count;
	} // end of add()
	
	
	public void removeOne(T item) {
		Node<T> current = mHead;
		Node<T> previous = null;
		boolean flag = false;
		
		while (current != null) {
			if (mHead.item.toString().equals(item.toString())) {
				mHead = mHead.nextNode;
				flag = true;
				break;
			} else if (current.item.toString().equals(item.toString())) {
				previous.nextNode = current.nextNode;
				flag = true;
				break;
			} else {
				previous = current;
				current = current.nextNode;
			}
		}
		
		if (flag) {
			mLength --;
		}
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		Node<T> current = mHead;
		while (current !=null) {
			removeOne(item);
			current = current.nextNode;
		}
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {

		String[] itemSet = new String[mLength];
		int numberOfPrint = 0;
		int numberOfItem = 0;
		Node<T> current = mHead;
		while(current != null) {
			if (itemSet[0] == null) {
				out.println(current.item + printDelim + search(current.item));
				itemSet[0] = current.item.toString();
				numberOfPrint += search(current.item);
				numberOfItem++;
			}else {
				for(String item: itemSet){
					if(item == null) {
						out.println(current.item + printDelim + search(current.item));
						itemSet[numberOfItem] = current.item.toString();
						numberOfPrint += search(current.item);
						numberOfItem ++;
						break;
					}
					else if(item.toString().equals(current.item.toString())) {
						break;
					}
				}
				current = current.nextNode;
			}
			if(mLength <= numberOfPrint) {
				break;
			}
		}
	}
} // end of class SortedLinkedListMultiset
