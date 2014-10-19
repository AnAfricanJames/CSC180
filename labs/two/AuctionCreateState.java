import java.util.Scanner;

public class AuctionCreateState implements Event
{
	Scanner scan;
	private String name;
	private String description;
	private String _price;
	private int price;
	private String UserName;
	Auction newItem;
	
	public AuctionCreateState(String _UserName, Scanner _scan)
	{
		this.scan = _scan;
		this.UserName = _UserName;
	}

	@Override
	public void show()
	{
		System.out.println(UserName + ", Please enter the name of the item you wish to create.");
		name = scan.nextLine();
		System.out.println("Please enter the description of the item.");
		description = scan.nextLine();
		System.out.println("What will be the starting price of these item? (Hit Enter to default to One Dollar)");
		_price = scan.nextLine(); 
		
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
		
		newItem = new Auction(0, name, price, description);
		UserHomeState.service.create(newItem);
		
		System.out.println(name + " Created!");
	}

	@Override
	public Event next()
	{
		return new UserHomeState(UserName);
	}
}
