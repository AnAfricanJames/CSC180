import java.util.*;


public class EventLoop
{
	boolean Complete = false;	
	
	DefaultState defualt = new DefaultState(); 
	
	Queue<Event> tasksBegin = new LinkedList<Event>();
	Queue<Event> tasksEnd = new LinkedList<Event>();
	
	void begin()
	{
		init();
		boolean IsDone = false;
		
		while(true)
		{
			while(IsDone == false)
			{
				if (!tasksBegin.isEmpty())
				{
					Event temp = (Event)tasksBegin.poll();
					temp.show();
					Event temp2 = temp.next();
					if (!(temp2 == null))
					{
						tasksEnd.offer(temp.next());
					}
				}
				else
				{
					IsDone = true;
				}
			}
			
			tasksEnd.offer(new DefaultState());
			
			while (IsDone == true)
			{
				if (!tasksEnd.isEmpty())
				{
					Event temp = (Event)tasksEnd.poll();
					temp.show();
					Event temp2 = temp.next();
					if (!(temp2 == null))
					{
						tasksBegin.offer(temp.next());
					}
				}
				else
				{
					IsDone = false;
				}
			}
			
		}
	 }
	
	public void init()
	{
		tasksBegin.add(new DefaultState());
		tasksBegin.add(new DefaultState());
		tasksBegin.add(new DefaultState());
	}
}
