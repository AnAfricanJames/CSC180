
public interface AuctionInterface
{
	Auction[] search(String criteria);
	Auction create(Auction auction);
	Auction retreive(Integer id);
	Auction update(Auction auctoin, Integer id);
	void delete(Integer id);
	void bid(String username, int itemId);
}
