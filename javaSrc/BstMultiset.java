import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T>
{
	public BstMultiset() {
		// Implement me!
	} // end of BstMultiset()

	public void add(T item) {
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
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
	} // end of print()

} // end of class BstMultiset
