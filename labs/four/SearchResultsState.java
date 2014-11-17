import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SearchResultsState implements Event
{
	private String input;
	private String UserName;
	private int inputId;
	InMemoryAuctionService service;
	Auction[] SearchResults;
	SimpleDateFormat convert;
	Scanner scan;
	
	public SearchResultsState(String _UserName, Auction[] _SearchResults, Scanner _scan, InMemoryAuctionService _service, SimpleDateFormat _convert)
	{
		this.convert = _convert;
		this.scan = _scan;
		this.SearchResults = _SearchResults;
		this.UserName = _UserName;
		this.service = _service;
	}
	
	@Override
	public void show()
	{	
		TableRowAuctionConverter convertTable = new TableRowAuctionConverter();
		Date date = new Date();
		
		for (Auction item : SearchResults)
		{
			if (item.endsBy().after(date) == true)
			{
				try
				{
					service.delete(item.getId());
					throw new Exception("ObjectNotFoundException");
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		convertTable.format(SearchResults);

		System.out.println(UserName + ", Would you like to edit an item, search again or bid.(S to search, B to bid, E to edit)");
		input = scan.nextLine();
		
		if (input.equalsIgnoreCase("b"))
		{
			System.out.println("Enter the item id to increase the bid by $1.");
			inputId = scan.nextInt();
			scan.nextLine();
		}
		else if (input.equalsIgnoreCase("e"))
		{
			System.out.println("Please enter item id to edit item.");
			inputId = scan.nextInt();
			scan.nextLine();
		}
	}

	@Override
	public Event next()
	{
		if (input.equalsIgnoreCase("s"))
		{
			return new UserHomeState(UserName, scan, service, convert);
		}
		else if (input.equalsIgnoreCase("b"))
		{
			service.bid(UserName, inputId);
		}
		else if (input.equalsIgnoreCase("e"))
		{
			return new FileBasedDataSource(UserName, inputId, scan, service, convert, SearchResults);
		}
		
		return  new SearchResultsState(UserName, SearchResults, scan, service, convert);
	}
}
