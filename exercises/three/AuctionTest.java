
public class AuctionTest
{
	
	public static void main(String[] args)
	{
		Auction auction = new Auction(0, "Guitar", 1);
		Auction auction2 = new Auction(0, "SkateBoard", 1);
		InMemoryAuctionService service = new InMemoryAuctionService();
		System.out.println(service.create(auction));
		System.out.println("Before Update: " + service.retreive(0));
		System.out.println("Update" + service.update(auction2, 0));
		System.out.println("After Update: " + service.retreive(0));
		service.delete(0);
		System.out.println("After Delete: " + service.retreive(0));
		//EventLoop loop = new EventLoop();
		//loop.begin();
	}
}
