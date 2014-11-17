public class TableRowAuctionConverter implements Converter<Auction>
{
	@Override
	public Auction parse(String fromString)
	{
		return null;
	}

	@Override
	public String format(Auction[] fromObject)
	{
		try
		{
			System.out.println();
			System.out.println(" ╔═══════════════════╦════════════════════╦════════════════════╦════════════════════╦═══════════════════╦═══════════════════════════════╗ ");
			System.out.println(" ║      Name         ║    Description     ║    Owner           ║   ID               ║    CurrentBid     ║	 Ends By                ║ ");
			System.out.println(" ╠═══════════════════╬════════════════════╬════════════════════╬════════════════════╬═══════════════════╬═══════════════════════════════╣ ");
			for (Auction item : fromObject)
			{
			System.out.println(" ║ "+item.getName()+"        ║  "+item.getDescription()+"     ║   "+item.getOwner()+"             ║            "+item.getId()+"       ║ "+item.getCurrentBid()+"               ║ "+item.endsBy()+"  ║");
			}
			System.out.println(" ╚═══════════════════╩════════════════════╩════════════════════╩════════════════════╩═══════════════════╩═══════════════════════════════╝ ");
		}
		catch (Exception e)
		{
			return null;
		}
		
		return fromObject.toString();
	}
	
	//This is for Name, Description, Owner, Id, CurrentBid
	public String pad(Object obj)
	{
		String object = obj.toString();
		int difference = 20 - object.length();
		StringBuilder buildNonPrint = new StringBuilder(object);
		
		if (obj.toString().length() < 20)
		{
			for (int x = 0; x <= difference; x++)
			{
				buildNonPrint.insert(object.length(), Character.toString((char)0));
			}
		}
		else if (object.length() > 20)
		{
			buildNonPrint.delete(20, object.length());
			object.substring(0, 20);
		}
		
		return buildNonPrint.toString();
	}
}
