public class TableRowAuctionConverter implements Converter<Auction>
{
	@Override
	public Auction parse(String fromString)
	{
		return null;
	}

	@Override
	public String format(Auction fromObject)
	{
		try
		{
			System.out.println(" ╔══════════════════╦═════════════════════╦════════════════╦══════════╦══════════════════╦═════════════════════╗ ");
			System.out.println(" ║      Name        ║    Description      ║ Owner          ║ID        ║    CurrentBid    ║	 Ends By           ║ ");
			System.out.println(" ╠══════════════════╬═════════════════════╬════════════════╬══════════╬══════════════════╬═════════════════════╣ ");
			System.out.println(" ║ "+fromObject.getName()+"         ║"+fromObject.getDescription()+"║ "+fromObject.getOwner()+"     ║ "+fromObject.getId()+"        ║ "+fromObject.getCurrentBid()+"                ║║ "+fromObject.getEndDate()+"                ║");
			System.out.println(" ╚══════════════════╩═════════════════════╩════════════════╩══════════╩══════════════════╩═════════════════════╝ ");
		}
		catch (Exception e)
		{
			return null;
		}
		
		return fromObject.toString();
	}
}
