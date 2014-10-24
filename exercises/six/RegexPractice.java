import java.util.*;
import java.util.regex.*;

public class RegexPractice
{
	public List<String> extractOperators(String extractOperators)
	{
		
		List<String> operatorList = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile("\\D\\W");
		Matcher match = pattern.matcher(extractOperators);
		
		//input sequence that matches the operators pattern
		while (match.find())
		{
			operatorList.add(match.group());
		}
		return operatorList;
	}
	
	public List<String> extractNumbers(String extractNumbers)
	{
		List<String> numberList = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile("-?\\d+\\.?");
		Matcher match = pattern.matcher(extractNumbers);
		
		while (match.find())
		{
			numberList.add(match.group());
		}
		
		return numberList;
	}
	
	public List<String> extractEmails(String message)
	{
		List<String> emailList = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile("([_A-Za-z0-9-]+)(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})");
		Matcher match = pattern.matcher(message);
		
		while (match.find())
		{
			emailList.add(match.group());
		}
		
		return emailList;
	}
	
	public List<String> extractListBody(String payload)
	{
		List<String> listBodyList = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile("<li>(.+?)</li>");
		Matcher match = pattern.matcher(payload);
		
		while (match.find())
		{
			listBodyList.add(match.group(1));
		}
		
		return listBodyList;
	}
}
