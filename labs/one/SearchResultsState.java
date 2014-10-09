import java.util.Scanner;

import javax.naming.directory.SearchResult;

public class SearchResultsState implements Event
{
	private int integer = 0;
	private String inputId;
	private String input;
	private String UserName;
	Auction[] SearchResults;
	
	Scanner scan = new Scanner(System.in);
	
	public SearchResultsState(String _UserName, Auction[] _SearchResults)
	{
		SearchResults = _SearchResults;
		UserName = _UserName;
	}
	
	@Override
	public void show()
	{
		boolean Done = false;
		
		for (Auction item : SearchResults)
		{
			System.out.println("Search Results: " + item);
		}
		
		System.out.println(UserName + ", Would you like to search again or bid.(S to search, B to bid)");
		input = scan.nextLine();
		
		if (input.equalsIgnoreCase("b"))
		{
			for (Auction item : SearchResults)
			{
				System.out.println("Search Results: " + item);
			}
			
			while (!Done)
			{	
				System.out.println("Enter the item id to increase the bid by $1.");
				inputId = scan.nextLine();
				try
				{
					integer = Integer.parseInt(inputId);
					Done = true;
				}
				catch(Exception e)
				{
					System.err.println("Invalid Number");
				}
			}
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
			UserHomeState.service.bid(UserName, integer);
		}
		
		return  new SearchResultsState(UserName, SearchResults);
	}
	
}
