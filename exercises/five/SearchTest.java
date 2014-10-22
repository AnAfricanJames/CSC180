import org.junit.Test;


public class SearchTest
{
	InMemoryAuctionService service = new InMemoryAuctionService();
	
	@Test
	public void test()
	{
		service.search("Television");
		service.search("PS3");
		service.search("Games");
		service.search("Living or Clothes");
		service.search("Games and Entertainment");
	}
}
