public class ContainsPredicate<T> implements Predicate<Auction>
{
	InMemoryAuctionService service;
	
	public ContainsPredicate(InMemoryAuctionService _service)
	{
		service = _service;
	}
	
	@Override
	public boolean evaluate(Auction t)
	{
		if (service.retreive(t.getName().hashCode()) != null)
		{
			return true;
		}
			
		return false;
	}
}
