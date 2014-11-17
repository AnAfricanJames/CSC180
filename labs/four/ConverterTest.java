import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;


public class ConverterTest
{
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	Date endDate;
	Auction item = new Auction(1, "Wallet", 1, "Saves Money", "James", 680000000);
	
	public ConverterTest() throws ParseException
	{
		endDate = format.parse("1-16-2015");
	}

	@Test
	public void testSimpleDateFormatConverter() throws ParseException
	{
		Converter<Date> dates = new SimpleDateFormatConverter(format);	
		format.parse("01-16-2015");
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
		//row.format(item);
		row.format(null);
	}
}
