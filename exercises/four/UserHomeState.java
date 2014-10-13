import java.util.Scanner;


public class UserHomeState implements Event
{
	Scanner scan = new Scanner(System.in);
	public static InMemoryAuctionService service = new InMemoryAuctionService();
	
	private String UserName;
	private Auction[] searchResults = new Auction[0];
	
	public UserHomeState(String _UserName)
	{
		UserName = _UserName;
	}

	@Override
	public void show()
	{
		System.out.println( UserName + ", What would you like to search for?");
		String UserInput = scan.nextLine();
		
		if (!UserInput.isEmpty())
		{
			searchResults = service.search(UserInput);
		}
	}

	@Override
	public Event next()
	{
		return new SearchResultsState(UserName, searchResults);
	}


}
