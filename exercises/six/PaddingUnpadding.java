public class PaddingUnpadding
{
	public String pad(Object obj, int len)
	{
		String object = obj.toString();
		int difference = len - object.length();
		StringBuilder buildNonPrint = new StringBuilder(object);
		
		if (obj.toString().length() < len)
		{
			for (int x = 0; x <= difference; x++)
			{
				buildNonPrint.insert(object.length(), Character.toString((char)0));
			}
		}
		else if (object.length() > len)
		{
			buildNonPrint.delete(len, object.length());
			object.substring(0, len);
		}
		
		return buildNonPrint.toString();
	}
	
	public Object unpad(String str)
	{
		String objClass = null;
		String newStr = null;
		int x = 0;

		for (char ch : str.toCharArray())
		{
			int ascii = (int)ch;
			
			if (ascii < 36)
			{
				newStr = str.replace(" ", "").substring(0, x);
				
				//double
				if (newStr.matches("\\d+\\.\\d+"))
				{
					objClass = "Double";
				}
				//int
				else if (newStr.matches("-?\\d{1,10}"))
				{
					objClass = "int";
				}
				//long
				else if (newStr.matches("-?\\d{1,19}"))
				{
					objClass = "Long";
				}
				//String
				else 
				{
					objClass = "String";
				}
				
			}
			else
			{
				x++;
			}
		}

		return objClass + "("+newStr+")";
	}
	
	public <T> T unpad(String str, Class<T> clazz)
	{
		T result = null;
		//T is instance of type class
		
		int x = 0;

		for (char ch : str.toCharArray())
		{
			int ascii = (int)ch;
			if (ascii < 31)
			{
				str.substring(0, x);
			}
			else
			{
				x++;
			}
		}
		
		try
		{
			if (clazz.isPrimitive())
			{
				if (clazz == Integer.class)
				{
					Integer.parseInt(str);
				} 
				else if (clazz == Double.class)
				{
					Double.parseDouble(str);
				} 
				else if (clazz == Long.class)
				{
					Long.parseLong(str);
				}
			}
		}
		catch(NumberFormatException e)
		{
			
		}
		
		return result;
	}
}	
