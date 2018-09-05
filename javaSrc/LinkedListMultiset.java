import java.io.PrintStream;

public class LinkedListMultiset<T> extends Multiset<T>
{	
	private class Node {
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
	
	
	public LinkedListMultiset() {
		mHead = null;
		length = 0;
	} // end of LinkedListMultiset()
	
	public void add(T item) {
					
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
		
	} // end of search()
	
	
	public void removeOne(T item) {
		// Implement me!
		Node current = mHead;
		Node previous = null;
		for(int i=length;i>0;i--){
			if(item.toString().equals(current.item.toString())) {
				if(current == mHead) {
					mHead = current.nextNode;
				}else
					previous.nextNode = current.nextNode;
				length = length - 1;
				break;
			}
			previous = current;
			current = current.nextNode;
		}
		
//github.com/ganfen9173/AA_Assignment1.git
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
		Node current = mHead;
		while (current !=null) {
			removeOne(item);
			current = current.nextNode;
		}
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		String[] itemSet = new String[length];
		int numberOfPrint = 0;
		int numberOfItem = 0;
		Node current = mHead;
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

			if(length <= numberOfPrint) {
				break;
			}
		}

	}// end of print()
	
} // end of class LinkedListMultiset
