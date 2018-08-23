import java.io.PrintStream;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		LinkedListMultiset<String> list= new LinkedListMultiset<>();
		MultisetTester tester = new MultisetTester();
		
		list.add("robot");
		list.add("fortune");
		list.add("macbook");
		list.add("robot");
		list.search("robot");
		list.add("macbook");
		list.add("macbook");
		list.add("fortune");
		list.removeOne("fortune");
		
		
		//System.out.println(list.search("fortune"));
		//System.out.println(list.);
		
		list.print(tester.outStream);

	}

}
