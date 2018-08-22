import java.io.PrintStream;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListMultiset<String> list= new LinkedListMultiset<>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("b");
		list.add("a");
		
		System.out.println(list);
		System.out.println(list.search("a"));

	}

}
