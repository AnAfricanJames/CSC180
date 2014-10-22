
public interface Converter<T>
{
	/***
	 * turn a string into a T
	 * @param fromString
	 * @return
	 */
	T parse(String fromString);
	/***
	 * turn a T into a string
	 * @param fromObject
	 * @return
	 */
	String format(T fromObject);
}
