
public class AuctionTest
{

	public static void main(String[] args)
	{
		InMemoryAuctionService service = new InMemoryAuctionService();
		service.bid("James", 1);
		service.bid("Emerson", 2);
		service.bid("Alix", 3);
		service.bid("Derek", 4);
		service.bid("Chris", 5);
		service.bid("Alix", 1);
		
		Auction[] resultTele = service.search("Tel");
		Auction[] resultPS3 = service.search("P");
		Auction[] resultHouse = service.search("H");
		Auction[] resultXbox = service.search("Xbo");
		Auction[] resultShoes = service.search("Sho");

		for (int x = 0; x < service.items.length; x++)
		{
			System.out.println("Search Result Television: " + resultTele[x]);
			System.out.println("Search Result PS3: " + resultPS3[x]);
			System.out.println("Search Result House: " + resultHouse[x]);
			System.out.println("Search Result Xbox: " + resultXbox[x]);
			System.out.println("Search Result Shoes: " + resultShoes[x]);
		}
	}
}
