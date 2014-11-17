import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SimpleDateFormatConverter implements Converter<Date>
{
	private SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String[] formats = {"dd-MM-yyyy"}; 
	private SimpleDateFormat forFormatting;
	
	/*
	 * class will use a default sdf
	 */
	public SimpleDateFormatConverter()
	{
		forFormatting = _sdf;
	}
	
	/*
	 * class will use the given sdf for both parsing and formating
	 * @param sdf
	 */
	public SimpleDateFormatConverter(SimpleDateFormat sdf)
	{
		if (sdf == null)
		{
			forFormatting = sdf;
		}
		else
		{
			_sdf = sdf;
		}
	}
	
	/*
	 * call will use the given sdfs for parsing and formatting
	 * @param forParsing
	 * @param forFormatting
	 */
	public SimpleDateFormatConverter(SimpleDateFormat _forParsing, SimpleDateFormat _forFormatting)
	{
		forFormatting = _forFormatting;
	}
	
	/*
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
				convertString = _sdf.parse(fromString);
			}
			catch(ParseException  e)
			{
				System.err.println("Invalid Date");
			}
		}
		return convertString;
	}

	@Override
	public String format(Date[] fromObject)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * turn T to string
	 */
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
				System.err.println("Invalid Date");
			}
		}
		return convertString;
	}
}
