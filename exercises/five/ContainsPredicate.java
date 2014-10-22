public class ContainsPredicate<T> implements Predicate<Auction>
{
	private String search;
	
	public ContainsPredicate(String _search)
	{
		this.search = _search;
	}
	
	@Override
	public boolean evaluate(Auction t)
	{
		return (t.getName().contains(search) || t.getDescription().contains(search));
	}
}
