import java.text.SimpleDateFormat;
import java.util.*;

public class AuctionCreateState implements Event
{
	private Scanner scan;
	private InMemoryAuctionService service;
	private String UserName;
	SimpleDateFormatConverter convert = new SimpleDateFormatConverter( new SimpleDateFormat("dd/MM/yyyy"));


	public AuctionCreateState(String _UserName, Scanner _scan, InMemoryAuctionService _service)
	{
		this.service = _service;
		this.scan = _scan;
		this.UserName = _UserName;
	}

	@Override
	public void show()
	{
		int price;
		long endDate = 0;
		
		System.out.println(UserName + ", Please enter the name of the item you wish to create.");
		String name = scan.nextLine();
		System.out.println("Please enter the description of the item.");
		String description = scan.nextLine();
		System.out.println("What will be the starting price of these item? (Hit Enter to default to One Dollar)");
		String _price = scan.nextLine(); 
		System.out.println("When will the Auction End?(dd/MM/yyyy or dd.MM.yyyy)");
		String _endDate = scan.nextLine();
		Date date = convert.parse(_endDate);
		
		if (_price.isEmpty())
		{
			price = 1;
		}
		else 
		{
			try
			{
				price = Integer.parseInt(_price);
			}
			catch(NumberFormatException e)
			{
				price = 1;
			}
		}
		
		Auction newItem = new Auction(0, name, price, description);
		
		if (_endDate.isEmpty())
		{
			endDate = System.currentTimeMillis() + 605000000;
		}
		else
		{
			newItem.setEndDateInMills(date.getTime());
		}
		
		newItem.setEndDateInMills(endDate);
		newItem.setNumberofbids(0);
		service.create(newItem);
		
		System.out.println(name + " Created!");
	}

	@Override
	public Event next()
	{
		return new UserHomeState(UserName, scan, service);
	}
}