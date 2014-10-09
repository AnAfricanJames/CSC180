public class Auction
{
	private String owner;
	final private String name;
	final private int id;
	private int currentBid;

	public Auction(int _id, String _name, int _currentBid)
	{
		this.id = _id;
		this.name = _name;
		this.setCurrentBid(_currentBid);
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auction other = (Auction) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "owner = " + getOwner() + ", name = " + name + ", id = " + id
				+ ", currentBid = " + getCurrentBid();
	}

	public int getCurrentBid()
	{
		return currentBid;
	}

	public void setCurrentBid(int currentBid)
	{
		this.currentBid = currentBid;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}
}
