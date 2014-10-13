import java.util.*;

public class InMemoryAuctionService implements AuctionInterface
{
	CollectionUtils util = new CollectionUtils();
	//Predicate<Auction> predicate = new ContainsPredicate();

	private int auctionIdCount = 0;
	Auction itemRequested;
	Auction[] items = new Auction[]{new Auction(1,"Television",0), new Auction(2,"PS3",0), new Auction(3,"House",0), new Auction(4,"Xbox",0), new Auction(5,"Shoes",0)};
	Map <Integer, Auction> auctionItems = new HashMap<Integer, Auction>();
	
	public Auction[] search(String criteria)
	{
		//util.filter(auctionItems, predicate);
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
		// auctionItems.values()
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
		auctionIdCount++;
		Auction newAuction = new Auction(auctionIdCount, auction.getName(), 0);
		auctionItems.put(newAuction.getName().hashCode(), newAuction);
		
		return newAuction;
	}

	@Override
	public Auction retreive(Integer id)
	{
		itemRequested = auctionItems.get(id);
		
		if (auctionItems.containsKey(id) == false)
		{
			try
			{
				throw new Exception("ObjectNotFoundException");
			} 
			catch (Exception e)
			{
				//e.printStackTrace();
			}
		}
		return itemRequested;
	}

	@Override
	public Auction update(Auction auction, Integer id)
	{
		if (auction.getId() != id)
		{
			try
			{
				throw new Exception("IdMismatchException");
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
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
