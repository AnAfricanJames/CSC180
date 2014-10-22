
public class OrPredicate implements Predicate<Auction>
{
	private Predicate<Auction> first;
	private Predicate<Auction> second;
	
	public OrPredicate(Predicate<Auction> _first, Predicate<Auction> _second)
	{
		this.first = _first;
		this.second = _second;
	}
	@Override
	public boolean evaluate(Auction t)
	{
		return first.evaluate(t) || second.evaluate(t);
	}

}
