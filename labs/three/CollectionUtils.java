import java.util.*;

public class CollectionUtils
{
	public static <T> Collection<T> filter(Collection<T> coll, Predicate<T> _predicate)
	{
		List<T> results = new ArrayList<T>();
		
		for (T element : coll)
		{
			if(_predicate.evaluate(element))
			{
				results.add(element);
			}
		}
		return results;
	}
}
