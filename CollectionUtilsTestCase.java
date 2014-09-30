import java.util.ArrayList;


public class CollectionUtilsTestCase
{

	public static void main(String[] args)
	{
		CollectionUtils util = new CollectionUtils();
		ArrayList<String> test = new ArrayList<String>();
		
		test.add("Texas");
		test.add("Texas");
		test.add("Texas");
		test.add("Texas");
		test.add("Texas");
		test.add("New York");
		test.add("New York");
		test.add("New York");
		test.add("New York");
		test.add("New York");
		test.add("Louisiana");
		test.add("Utah");
		test.add("Utah");
		test.add("Utah");
		test.add("Utah");
		test.add("California");
		test.add("Colorado");
		test.add("Colorado");
		test.add("Colorado");
		test.add("Washington");
		test.add("Washington");
		
		System.out.println(" ", test);
		System.out.println(util.cardinality("Texas", test));
		System.out.println(util.cardinality("New York", test));
		System.out.println(util.cardinality("Colorado", test));
		System.out.println(util.cardinality("Utah", test));
		System.out.println(util.cardinality("Washington", test));

	}

}
