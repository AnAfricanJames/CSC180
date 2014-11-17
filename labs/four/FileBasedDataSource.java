import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileBasedDataSource implements Event
{
	private String UserName;
	private int inputId;
	private Auction[] SearchResults;
	private Scanner scan;
	private InMemoryAuctionService service;
	private SimpleDateFormat convert;
	
	public FileBasedDataSource(String _UserName, int _inputId, Scanner _scan, 
			InMemoryAuctionService _service, SimpleDateFormat _convert, Auction[] _SearchResults)
	{
		this.UserName = _UserName;
		this.inputId = _inputId;
		this.SearchResults = _SearchResults;
		this.scan = _scan;
		this.service = _service;
		this.convert = _convert;
	}
	
	@Override
	public void show()
	{		
		for (Auction item : SearchResults)
		{
			if (inputId == item.getId())
			{
				if (UserName == item.getCreator())
				{
					System.out.println(UserName + ", Welcome to edit, Would you like to delete this item.(Y/N)");
					String input = scan.nextLine();
					
					if (input.equalsIgnoreCase("Y"))
					{
						service.delete(item.getId());
						System.out.println("Item Deleted");
					}
					else
					{	
						edit(item);
					}
				}
			}
			else
			{
				System.out.println(UserName + ", did not create item " + item.getName());
			}
		}
	}

	@Override
	public Event next()
	{
		return new UserHomeState(UserName, scan, service, convert);
	}
	
	public void edit(Auction itemResult)
	{
		String inputCurrentPrice;
		String inputName = "";
		int price = 0;

		System.out.println("What is the new description for the item. (Press Enter to keep the same description)");
		String inputDescription = scan.nextLine();
		if (inputDescription.isEmpty())
		{
			inputDescription = itemResult.getDescription();
		}	
			
		if (itemResult.getCurrentBid() == itemResult.getInitialBid())
		{
			System.out.println("What's the item's new name.(Press Enter to keep same name)");
			inputName = scan.nextLine();
			if (inputName.isEmpty())
			{
				inputName = itemResult.getName();
			}
				
			System.out.println("When would you like to end the bid. (Press Enter to keep current end date)");
			String _endDate = scan.nextLine();
				
			System.out.println("What is the starting cost of this item(Press Enter to default to $1)");
			inputCurrentPrice = scan.nextLine();
			if (inputCurrentPrice.isEmpty())
			{
				price = 1;
			}
			else 
			{
				try
				{
					price = Integer.parseInt(inputCurrentPrice);
				}
				catch(NumberFormatException e)
				{
					price = 1;
				}
			}
		}
		else
		{
				System.err.println("Bids already placed, cannot change Name, Date and Bid");
		}
		
		//This class is the only one that needs to implemenent end date, create too.
		Auction item = new Auction(itemResult.getId(), inputName, price, inputDescription);
			
		service.update(item, itemResult.getId());
	}
}
