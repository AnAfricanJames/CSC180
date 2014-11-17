import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AuctionCreateState implements Event
{
	private Scanner scan;
	private InMemoryAuctionService service;
	private String UserName;
	private SimpleDateFormat convert;

	public AuctionCreateState(String _UserName, Scanner _scan, InMemoryAuctionService _service)
	{
		this.service = _service;
		this.scan = _scan;
		this.UserName = _UserName;
	}

	@Override
	public void show()
	{
		String[] formats = {"dd/MM/yyyy", "dd-MM-yyyy"};
		int price;
		long endDate = 0;
		Date date = new Date();
		
		System.out.println(UserName + ", Please enter the name of the item you wish to create.");
		String name = scan.nextLine();
		System.out.println("Please enter the description of the item.");
		String description = scan.nextLine();
		System.out.println("What will be the starting price of these item? (Hit Enter to default to One Dollar)");
		String _price = scan.nextLine(); 
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
		System.out.println("When will the Auction End? Press enter to default to seven days. (dd/MM/yyyy)");
		String _endDate = scan.nextLine();
		if (_endDate.isEmpty())
		{
			endDate = TimeUnit.DAYS.toMillis(7) + date.getTime();
		}
		else
		{
			for (String format : formats)
			{
				try
				{
					convert = new SimpleDateFormat(format);
					date = convert.parse(_endDate);
					endDate = date.getTime();
					System.err.println("Milliseconds" + endDate);
				} 
				catch (ParseException e) {}
			}
		}
		
		Auction newItem = new Auction(0, name, price, description, UserName, endDate);
		service.create(newItem);
		
		System.out.println(name + " Created!");
	}

	@Override
	public Event next()
	{
		return new UserHomeState(UserName, scan, service, convert);
	}
}