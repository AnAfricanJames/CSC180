import java.util.Scanner;

public class SearchResultsState implements Event
{
	private String input;
	private String UserName;
	private int inputId;
	InMemoryAuctionService service;
	Auction[] SearchResults;
	Scanner scan;
	
	public SearchResultsState(String _UserName, Auction[] _SearchResults, Scanner _scan, InMemoryAuctionService _service)
	{
		this.scan = _scan;
		this.SearchResults = _SearchResults;
		this.UserName = _UserName;
		this.service = _service;
	}
	
	@Override
	public void show()
	{	
		TableRowAuctionConverter convert = new TableRowAuctionConverter();
		for (Auction item : SearchResults)
		{
			convert.format(item);
			//System.out.println("Search Results: " + item);
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
			return new UserHomeState(UserName, scan, service);
		}
		else if (input.equalsIgnoreCase("b"))
		{
			service.bid(UserName, inputId);
		}
		
		return  new SearchResultsState(UserName, SearchResults, scan, service);
	}
}
