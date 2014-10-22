
public class AuctionTest
{
	
	public static void main(String[] args)
	{
		Auction item = new Auction(1, "Wallet", 1, "Saves Money");
		TableRowAuctionConverter row = new TableRowAuctionConverter();
		row.format(item);
		/*
		AuctionCreateState state = new AuctionCreateState();
		state.show();
		
		EventLoop loop = new EventLoop();
		loop.begin();
		
		Auction auction1 = new Auction(0, "Guitar", 1);
		Auction auction2 = new Auction(1, "SkateBoard", 1);
		Auction auction3 = new Auction(2, "Projector", 1);
		Auction auction4 = new Auction(3, "Cup", 1);
		Auction auction5 = new Auction(4, "Shoes", 1);
		Auction auction6 = new Auction(5, "Mouse", 1);
		Auction auction7 = new Auction(6, "Dew", 1);
		
		System.out.println(service.create(auction1));
		System.out.println(service.create(auction2));
		System.out.println(service.create(auction3));
		System.out.println(service.create(auction4));
		System.out.println(service.create(auction5));
		System.out.println(service.create(auction6));
		System.out.println("");
		
		ContainsPredicate<Auction> predicate = new ContainsPredicate<Auction>(service);
		System.out.println("Auction7 has not been added to the hashmap.");
		System.out.println("Contains Predicate auction7: " + predicate.evaluate(auction7));
		System.out.println("Contains Predicate auction1: " + predicate.evaluate(auction1));
		System.out.println("Contains Predicate auction2: " + predicate.evaluate(auction2));
		System.out.println("Before Update: " + service.retreive(0));
		System.out.println("Update" + service.update(auction2, 0));

		service.delete(0);
		System.out.println("After Delete: " + service.retreive(0));
		
		 */
	}
}
