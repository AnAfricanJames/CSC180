import java.util.*;

public class DefaultState implements Event
{
	boolean Done = true;
	private String _UserName;
	Scanner scan = new Scanner(System.in);

	public DefaultState(){}
	
	/**
	 * prints a message to the screen
	 * indicating what the user should do.
	 */
	public void show()
	{
		System.out.println("New User, Would you like to log in, Enter name? (Hit Enter to decline)");
		_UserName = scan.nextLine();
		if (_UserName.isEmpty())
		{
			Done = false;
		}
	}
	
	/**
	 * takes in the user's next request
	 * and decides what state the user is now in.
	 * @return
	 */
	public Event next()
	{
		if (Done == false)
		{
			return null;
		}
		return new UserHomeState(_UserName);
	}
}
