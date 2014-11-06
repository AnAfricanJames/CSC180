import org.junit.Test;

public class PaddingUnpaddingTest
{

	@Test
	public void testPad()
	{
		PaddingUnpadding padding = new PaddingUnpadding();
		//If the object is too short
		padding.pad(1234, 20);
		//If the object if too long
		padding.pad(1234, 1);
		//If the object is the same size
		padding.pad(1234, 4);
	}
	
	@Test
	public void testUnpadObject()
	{
		PaddingUnpadding padding = new PaddingUnpadding();
		//I initially tested the unpadding with printable characters.
		padding.unpad("1234");
		//It passed my test.
	}
	
	@Test
	public void testUnpadT()
	{
		PaddingUnpadding unpad = new PaddingUnpadding();
		unpad.unpad("", String.class);
	}

}
