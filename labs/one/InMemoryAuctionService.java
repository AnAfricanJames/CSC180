import java.util.ArrayList;
import java.util.List;

public class InMemoryAuctionService implements AuctionInterface
{
	Auction[] items = new Auction[]{new Auction(1,"Television",0), new Auction(2,"PS3",0), new Auction(3,"House",0), new Auction(4,"Xbox",0), new Auction(5,"Shoes",0)};
	
	public Auction[] search(String criteria)
	{
		List<Auction> results = new ArrayList<Auction>();
		
		if (!criteria.isEmpty())
		{
			for (Auction item : items)
			{
				if (item.getName().contains(criteria))
				{
					results.add(item);
				}
			}
		}

		Auction[] resultreturn = results.toArray(new Auction[results.size()]);
		return (Auction[]) resultreturn;
	};

	public void bid(String username, int itemId)
	{
		for (Auction item : items)
		{
			if (item.getId() == itemId)
			{
				item.setCurrentBid(item.getCurrentBid() + 1);
				item.setOwner(username);
			}
		}
	};
}
