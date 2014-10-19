import java.util.Scanner;


public class UserHomeState implements Event
{
	Scanner scan = new Scanner(System.in);
	private String choice;
	private Auction[] searchResults = new Auction[0];
	public static InMemoryAuctionService service = new InMemoryAuctionService();
	private String UserName;
	
	public UserHomeState(String _UserName)
	{
		UserName = _UserName;
	}

	@Override
	public void show()
	{
		System.out.println( UserName + ", What would you like to search for? Press C to create an Item.");
		choice = scan.nextLine();
	
		if (!choice.isEmpty() && !choice.equalsIgnoreCase("C"))
		{
			searchResults = service.search(choice);
		}
	}

	@Override
	public Event next()
	{
		if (choice.equalsIgnoreCase("C"))
		{
			return new AuctionCreateState(UserName, scan);
		}
		return new SearchResultsState(UserName, searchResults, scan);
	}


}
