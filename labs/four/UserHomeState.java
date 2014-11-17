import java.text.SimpleDateFormat;
import java.util.Scanner;


public class UserHomeState implements Event
{
	Scanner scan;
	InMemoryAuctionService service;
	SimpleDateFormat convert;
	Auction[] SearchResults;
	private String choice;
	private String UserName;
	
	
	public UserHomeState(String _UserName, Scanner _scan, InMemoryAuctionService _service, SimpleDateFormat _convert)
	{
		this.convert = _convert;
		this.service = _service;
		this.scan = _scan;
		this.UserName = _UserName;
	}

	@Override
	public void show()
	{
		System.out.println( UserName + ", What would you like to search for? Press C to create an Item.");
		choice = scan.nextLine();
		
		if(!choice.equalsIgnoreCase("C"))
		{
			SearchResults = service.search(choice);
		}
	}

	@Override
	public Event next()
	{
		if (choice.equalsIgnoreCase("C"))
		{
			return new AuctionCreateState(UserName, scan, service);
		}
		return new SearchResultsState(UserName, SearchResults, scan, service, convert);
	}
}
