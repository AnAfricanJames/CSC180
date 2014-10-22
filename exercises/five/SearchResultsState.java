import java.util.Scanner;

import javax.naming.directory.SearchResult;

public class SearchResultsState implements Event
{
	private int inputId;
	private String input;
	private String UserName;
	private Auction[] SearchResults;
	
	Scanner scan;
	
	public SearchResultsState(String _UserName, Auction[] _SearchResults, Scanner _scan)
	{
		this.scan = _scan;
		this.SearchResults = _SearchResults;
		this.UserName = _UserName;
	}
	
	@Override
	public void show()
	{	
		for (Auction item : SearchResults)
		{
			System.out.println("Search Results: " + item);
		}
		
		System.out.println(UserName + ", Would you like to search again or bid.(S to search, B to bid)");
		input = scan.nextLine();
		
		if (input.equalsIgnoreCase("b"))
		{
			System.out.println("Enter the item id to increase the bid by $1.");
			inputId = scan.nextInt();
			scan.nextLine();
		}
	}

	@Override
	public Event next()
	{
		if (input.equalsIgnoreCase("s"))
		{
			return new UserHomeState(UserName);
		}
		else if (input.equalsIgnoreCase("b"))
		{
			UserHomeState.service.bid(UserName, inputId);
		}
		
		return  new SearchResultsState(UserName, SearchResults, scan);
	}
	
}
