import static org.junit.Assert.*;

import org.junit.Test;


public class RegexPracticeTest
{

	@Test
	public void testOperators()
	{
		RegexPractice testOperators = new RegexPractice();
		//testing for operators
		System.out.println(testOperators.extractOperators("3 + 2 / 4.0 * 1 ^ 17.34"));
		//testing for null
		System.out.println(testOperators.extractOperators(""));
		//testing for invalid input
		System.out.println(testOperators.extractOperators("asdsajdjs"));
	}
	
	@Test
	public void testNumbers()
	{
		RegexPractice testNumbers = new RegexPractice();
		//testing for numbers including decimal points
		System.out.println(testNumbers.extractNumbers("3 + 2 / 4.0 * 1 ^ 17.34"));
		//testing for null
		System.out.println(testNumbers.extractNumbers(""));
		//testing invalid input
		System.out.println(testNumbers.extractNumbers("adhsafdjdsfs"));
	}
	
	@Test
	public void testEmails()
	{
		RegexPractice testEmail = new RegexPractice();
		//testing for numbers including decimal points
		System.out.println(testEmail.extractEmails("Hello, my name is james taylor, you can reach me a thabisojt@gmail.com or at coylax@gmail.com"));
		//testing for null
		System.out.println(testEmail.extractEmails(""));
		//testing invalid input
		System.out.println(testEmail.extractEmails("refkjgdfgd"));
	}
	
	@Test
	public void testListBody()
	{
		RegexPractice testListBody = new RegexPractice();
		//testing for numbers including decimal points
		System.out.println(testListBody.extractListBody("<li>Hello, this is a payload created to test if my extractListBodyMethod works</li>"));
		//testing for null
		System.out.println(testListBody.extractListBody(""));
		//testing invalid input
		System.out.println(testListBody.extractListBody("lkdfjgldngjfd"));
	}

}
