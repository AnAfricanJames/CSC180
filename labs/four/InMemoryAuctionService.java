import java.util.*;

public class InMemoryAuctionService implements AuctionInterface
{
	private Map <Integer, Auction> auctionItems = new HashMap<Integer, Auction>();
	private int auctionIdCount = 5;
	private int count = 1;
	
	public InMemoryAuctionService()
	{
		auctionItems.put(0, new Auction(0,"Television",0, "Entertainment"));
		auctionItems.put(1, new Auction(1,"PS3",0, "Games"));
		auctionItems.put(2, new Auction(2,"House",0, "Living"));
		auctionItems.put(3, new Auction(3,"Xbox",0, "Games and Entertainment"));
		auctionItems.put(4,  new Auction(4,"Shoes",0, "Clothes"));
	}
	
	public InMemoryAuctionService(String source)
	{
		HtmlDump page = new HtmlDump();
		List<Auction> items = page.parseHtmlDump(source);
		
		for (Auction item : items)
		{
			create(item);
		}
	}
	
	public Auction[] search(String _criteria)
	{
		Scanner scan = new Scanner(_criteria);
		
		Stack<Predicate<Auction>> predicateStack = new Stack<Predicate<Auction>>();
		Stack<Operators> operatorStack = new Stack<Operators>();
		
		String word;
		
		Predicate<Auction> FirstPredicate;
		Predicate<Auction> SecondPredicate;
		Predicate<Auction> predicate = null;
		
		List<Auction> results = new ArrayList<Auction>();
		
		while (scan.hasNext())
		{
			word = scan.next();
			
			if (word.equalsIgnoreCase("or"))
			{
				//Because i can have more than one and, i am looping through the operators stack to see if and is not on top.
				while ((!operatorStack.isEmpty()) && operatorStack.peek().equals(Operators.AND))
				{
					//Taking the first two from predicate stack 
					FirstPredicate = predicateStack.pop();
					SecondPredicate = predicateStack.pop();
					//I'm popping off my and predicate because OR wants to enter the stack.
					operatorStack.pop();
					//Creating an AndPredicate
					predicate = new AndPredicate(FirstPredicate, SecondPredicate);
					//adding it to the predicate stack after popping off the two predicates before that. 
					predicateStack.push(predicate);
				}
				//Placing OR on the operator stack.
				operatorStack.push(Operators.OR);
			}
			else if (word.equalsIgnoreCase("and"))
			{
				//Placing AND on the operator stack.
				operatorStack.push(Operators.AND);
			}
			else
			{
				//Creating a ContainsPredicate and placing it on the Predicate Stack.
				predicate = new ContainsPredicate<Auction>(word);
				predicateStack.push(predicate);
			}
		}
		
		while (!operatorStack.isEmpty())
		{
			FirstPredicate = predicateStack.pop();
			SecondPredicate = predicateStack.pop();
			//Popping off the operator stack, by this time, it should be empty after this. 
			operatorStack.pop();

			predicate = new OrPredicate(FirstPredicate, SecondPredicate);
			predicateStack.add(predicate);
			
			if (operatorStack.isEmpty())
			{
				//Popping off the only remaining predicate and running it through the filter method.
				predicate = predicateStack.pop();
			}
		}
			
		results.addAll(CollectionUtils.filter(auctionItems.values(), predicate));
		scan.close();
		
		Auction[] resultreturn = results.toArray(new Auction[results.size()]);
		return (Auction[]) resultreturn;
	};

	@Override
	public void bid(String username, int itemId)
	{
		for (Auction item : auctionItems.values())
		{
			if (item.getId() == itemId )
			{
				item.setCurrentBid(item.getCurrentBid() + 1);
				item.setOwner(username);
				item.setnumberOfBidsRemaining(count);
				count++;
			}
		}
	}

	@Override
	public Auction create(Auction auction)
	{
		Auction newAuction = new Auction(auctionIdCount, auction.getName(), auction.getCurrentBid(), auction.getDescription(), auction.getCreator(), auction.getTimeLeftInMillis());
		auctionItems.put(newAuction.getId(), newAuction);
		auctionIdCount++;
		
		return newAuction;
	}

	@Override
	public Auction retreive(Integer id)
	{
		Auction itemRequested = auctionItems.get(id);
		
		if (auctionItems.containsKey(id) == false)
		{
			try
			{
				throw new Exception("ObjectNotFoundException");
			} 
			catch (Exception e)
			{
				e.printStackTrace();
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
		else
		{
			for (Auction item : auctionItems.values())
			{
				if (item.getId() == id)
				{
					auctionItems.put(item.getId(), auction);
				}
			}
		}
		return auction;
	}

	@Override
	public void delete(Integer id)
	{
		auctionItems.remove(id);
	}
}