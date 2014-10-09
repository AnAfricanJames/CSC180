import java.util.*;

public class InMemoryAuctionService implements AuctionInterface
{
	int auctionIdCount = 0;
	Auction[] items = new Auction[]{new Auction(1,"Television",0), new Auction(2,"PS3",0), new Auction(3,"House",0), new Auction(4,"Xbox",0), new Auction(5,"Shoes",0)};
	Map <Integer, Auction> auctionItems = new HashMap<Integer, Auction>();
	
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
		//auctionItems.values()
		for (Auction item : items)
		{
			if (item.getId() == itemId)
			{
				item.setCurrentBid(item.getCurrentBid() + 1);
				item.setOwner(username);
			}
		}
	}

	@Override
	public Auction create(Auction auction)
	{
		Auction newAuction = new Auction(auctionIdCount, auction.getName(), 0);
		auctionItems.put(auctionIdCount, newAuction);
		auctionIdCount++;
		
		return newAuction;
	}

	@Override
	public Auction retreive(Integer id)
	{
		Auction itemRequested = null;
		
		
		for (Auction item : auctionItems.values())
		{
			if (item.getId() == id)
			{
				itemRequested = item;
			}
		}
		if (itemRequested == null)
		{
			System.err.println("Item requested not Found");
		}
		return itemRequested;
	}

	@Override
	public Auction update(Auction auction, Integer id)
	{
		if (auction.getId() != id)
		{
			System.out.println("Item not found.");
		}
		for (Auction item : auctionItems.values())
		{
			if (item.getId() == auction.getId())
			{
				auctionItems.put(auction.getId(), auction);
			}
		}
		
		return auction;
	}

	@Override
	public void delete(Integer id)
	{
		auctionItems.remove(id);
	};
}
