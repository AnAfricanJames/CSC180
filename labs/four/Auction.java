import java.util.*;

public class Auction
{
	private Map<String, Object> properties = new HashMap<String, Object>();;
	private String owner;
	private String description;
	private String propertyName;
	private String creator;
	private Object propertyValue;
	private long timeLeftInMillis;
	private int externalId;
	private double initialBid;
	final private String name;
	final private int id;
	private int numberOfBidsRemaining;
	private double currentBid;

	public Auction(int _id, String _name, double _currentBid, String _description)
	{
		this.id = _id;
		this.name = _name;
		this.description = _description;
		this.currentBid = _currentBid;
	}
	
	public Auction(int _id, String _name, double _currentBid, String _description, long _timeLeftInMillis)
	{
		this.id = _id;
		this.name = _name;
		this.description = _description;
		this.currentBid = _currentBid;
	}
	
	public Auction(int _id, String _name, double _currentBid, String _description, String _creator, long _timeLeftInMillis)
	{
		this.timeLeftInMillis = _timeLeftInMillis;
		this.creator = _creator;
		this.id = _id;
		this.name = _name;
		this.description = _description;
		this.currentBid = _currentBid;
		this.initialBid = _currentBid;
	}
	
	
	public Auction(int _id, String _name, int _currentBid, Map<String, Object> _properties)
	{
		this.id = _id;
		this.name = _name;
		this.currentBid = _currentBid;
		this.properties = _properties;
	}
	
	public Map<String, Object> getProperties()
	{
		return properties;
	}
	
	public Object getProperty(String _propertyName)
	{
		return propertyName;
	}
	
	public Object getPropertyValues()
	{
		return propertyValue;
	}
	
	public double getInitialBid()
	{
		return this.initialBid;
	}
	
	public void setInitialBid(double _initialBid)
	{
		this.initialBid = _initialBid;
	}
	
	public Date endsBy()
	{
		return new Date(timeLeftInMillis);
	}
	
	public String getCreator()
	{
		return this.creator;
	}
	
	public int getExternalId()
	{
		return externalId;
	}
	
	public long getTimeLeftInMillis()
	{
		return timeLeftInMillis;
	}
	
	public void setCreator(String _creator)
	{
		this.creator = _creator;
	}
	
	public void setExternalId(int _externalId)
	{
		this.externalId = _externalId;
	}
	
	public void setProperty(String _propertyName, Object _propertyValue)
	{
		this.propertyName = _propertyName;
		this.propertyValue = _propertyValue;
	}
	
	public void setTimeLeftInMillis(long _timeLeftInMillis)
	{
		this.timeLeftInMillis = _timeLeftInMillis;
	}

	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
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

	public double getCurrentBid()
	{
		return currentBid;
	}

	public void setCurrentBid(double _currentBid)
	{
		this.currentBid = _currentBid;
	}
	
	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String _owner)
	{
		this.owner = _owner;
	}
	
	public int getnumberOfBidsRemaining()
	{
		return numberOfBidsRemaining;
	}
	
	public void setnumberOfBidsRemaining(int _numberOfBidsRemaining)
	{
		this.numberOfBidsRemaining = _numberOfBidsRemaining;
	}
	@Override
	public String toString()
	{
		return "owner = " + getOwner() + ", name = " + name + ", id = " + id
				+ ", currentBid = " + getCurrentBid();
	}

}
