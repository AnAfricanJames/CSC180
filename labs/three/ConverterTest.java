import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;


public class ConverterTest
{
	SimpleDateFormat format = new SimpleDateFormat();
	Date endDate;
	Auction item = new Auction(1, "Wallet", 1, "Saves Money");
	
	public ConverterTest() throws ParseException
	{
		endDate = format.parse("1/16/2015");
	}

	@Test
	public void testSimpleDateFormatConverter()
	{
		Converter<Date> dates = new SimpleDateFormatConverter(format);	
		dates.parse("01 16 1995");
	}
	@Test
	public void testCurrentDate()
	{
		Converter<Date> dates = new SimpleDateFormatConverter(format);
		Date d = new Date();
	
		dates.parse("01 16 1995");
		Assert.assertNotNull("21 October 2014",dates.format(d));
	}
	@Test
	public void testDefault()
	{
		Converter<Date> dates = new SimpleDateFormatConverter();
		dates.parse("01 16 1995");
	}
	
	//I have it printing out the Auction item in the AuctionTest Class.
	@Test
	public void testTableRowAuctionConverter()
	{
		TableRowAuctionConverter row = new TableRowAuctionConverter();
		row.format(item);
		row.format(null);
	}
}
