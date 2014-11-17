
public class AndPredicate implements Predicate<Auction>
{
	private Predicate<Auction> first;
	private Predicate<Auction> second;
	
	public AndPredicate(Predicate<Auction> _first, Predicate<Auction> _second)
	{
		this.first = _first;
		this.second = _second;
	}
	
	@Override
	public boolean evaluate(Auction t)
	{
		return first.evaluate(t) && second.evaluate(t);
	}
}
