
public interface AuctionInterface
{
	Auction[] search(String criteria);
	void bid(String username, int itemId);
}
