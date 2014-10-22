import java.text.SimpleDateFormat;
import java.util.Date;


public class SimpleDateFormatConverter implements Converter<Date>
{
	private SimpleDateFormat _sdf= new SimpleDateFormat("dd MMM yyyy");
	private SimpleDateFormat forParsing;
	private SimpleDateFormat forFormatting;
	
	/***
	 * class will use a default sdf
	 */
	public SimpleDateFormatConverter()
	{
		forParsing = _sdf;
		forFormatting = _sdf;
	}
	
	/***
	 * class will use the given sdf for both parsing and formating
	 * @param sdf
	 */
	public SimpleDateFormatConverter(SimpleDateFormat sdf)
	{
		if (sdf == null)
		{
			forParsing = sdf;
			forFormatting = sdf;
		}
		else
		{
			_sdf = sdf;
		}
	}
	
	/***
	 * call will use the given sdfs for parsing and formatting
	 * @param forParsing
	 * @param forFormatting
	 */
	public SimpleDateFormatConverter(SimpleDateFormat _forParsing, SimpleDateFormat _forFormatting)
	{
		forParsing = _forParsing;
		forFormatting = _forFormatting;
	}
	
	/***
	 * turn string to Object
	 * @throws  
	 */
	@Override
	public Date parse(String fromString) 
	{
		Date convertString = null;
		
		if (!fromString.isEmpty())
		{
			try
			{
				convertString = forParsing.parse(fromString);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return convertString;
	}
	
	/**
	 * turn T to string
	 */
	@Override
	public String format(Date fromObject)
	{
		String convertString = null;
		
		if (fromObject != null)
		{
			try
			{
				convertString = forFormatting.format(fromObject);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return convertString;
	}
}
